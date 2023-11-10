import {
  MdbTablePaginationComponent,
  MdbTableService,
  MdbTableDirective
} from "angular-bootstrap-md";

import {
  Component,
  OnInit,
  ViewChild,
  HostListener,
  AfterViewInit,
  ChangeDetectorRef
} from "@angular/core";

import { FormGroup, FormControl, Validators } from "@angular/forms";
import { UserService } from "./user.service";
import { User } from "./user";
import { Role } from "./role";
import { HttpEventType, HttpResponse } from "@angular/common/http";

@Component({
  selector: "app-user",
  templateUrl: "./user.component.html",
  styleUrls: ["./user.component.scss"]
})
export class UserComponent implements OnInit {
  @ViewChild(MdbTablePaginationComponent)
  mdbTablePagination: MdbTablePaginationComponent;

  isUserFormOpen = false;
  previous: any = [];
  data: object;
  formSubmitValue = "Create";
  loginEmail;
  formTitle = "Create New User";
  users: User[];
  elementVal: any = [];
  elements: any = [];
  firstItemIndex;
  lastItemIndex;
  headElements = ["FirstName", "LastName", "EMailId", "EmployeeId", "Role"];
  rolesList: Role[] = [];
  httpResponseMessage: string;

  constructor(
    private tableService: MdbTableService,
    private cdRef: ChangeDetectorRef,    
    private userService: UserService
  ) {}
  ngOnInit() {
    this.fetchData();
    this.userService.getCodeList("rolelist").subscribe(roles => {
      this.rolesList = roles;
    });
  }
  fetchData() {
    this.users = [];
    this.elements = [];
    this.elementVal = [];
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.elements.push({ data });
      for (let i = 0; i < this.elements.length; i++) {
        for (let j = 0; j < this.elements[i].data.length; j++) {
          this.elementVal.push({
            firstname: this.elements[i].data[j].firstName,
            lastname: this.elements[i].data[j].lastName,
            emailid: this.elements[i].data[j].mailId,
            employeeid: this.elements[i].data[j].empId,
            role: this.elements[i].data[j].role
          });
        }
      }
      this.tableService.setDataSource(this.elementVal);
      this.elementVal = this.tableService.getDataSource();
      this.previous = this.tableService.getDataSource();
      this.mdbTablePagination.setMaxVisibleItemsNumberTo(10);
      this.firstItemIndex = this.mdbTablePagination.firstItemIndex;
      this.lastItemIndex = this.mdbTablePagination.lastItemIndex;
      this.mdbTablePagination.calculateFirstItemIndex();
      this.mdbTablePagination.calculateLastItemIndex();
      this.cdRef.detectChanges();
    });
  }
  openUserForm() {
    this.isUserFormOpen = !this.isUserFormOpen;   
  }

  onNextPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }

  onPreviousPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }

  userForm = new FormGroup({
    firstName: new FormControl(""),
    lastName: new FormControl(""),
    emailId: new FormControl(""),
    employeeId: new FormControl(""),
    role: new FormControl("")
  });

  onSubmit() {
    const user: User = {
      firstName: this.userForm.controls["firstName"].value,
      lastName: this.userForm.controls["lastName"].value,
      role: this.userForm.controls["role"].value,
      empId: this.userForm.controls["employeeId"].value,
      mailId: this.userForm.controls["emailId"].value
    } as User;
    if (this.formSubmitValue == "Create") {
      this.userService.saveUser(user).subscribe(userObj => {
        this.postAction("User Saved Successfully");
        if (userObj instanceof HttpResponse) {
        }
      });
    } else {      
      this.userService.updateUser(user).subscribe(userObj => {
        this.postAction("User Data Edited Successfully");
        this.formTitle = "Create New User";
        this.formSubmitValue = "Create";
        this.userForm.controls["emailId"].enable();
        this.userForm.controls["employeeId"].enable();
        if (userObj instanceof HttpResponse) {
        }
      });
    }
  }

  reset(): void {
    this.userForm.reset();
  }

  postAction(message: string) {
    this.fetchData();
    this.httpResponseMessage = message;
    this.reset();
    this.openUserForm();
  }

  updateUser(user: any) {
    this.userForm.controls["firstName"].setValue(user.firstname);
    this.userForm.controls["lastName"].setValue(user.lastname);
    this.userForm.controls["role"].setValue(user.role);
    this.userForm.controls["employeeId"].setValue(user.employeeid);
    this.userForm.controls["emailId"].setValue(user.emailid);
    this.userForm.controls["emailId"].disable();
    this.userForm.controls["employeeId"].disable();
    this.formTitle = "Update User";
    this.formSubmitValue = "Update";
    this.openUserForm();
  }

  removeUser(mailId: string) {    
    this.users = this.users.filter(x => x.mailId !== mailId);
    this.userService.deleteUser(mailId).subscribe(userObj => {
      this.fetchData();
      this.httpResponseMessage = "User " + mailId + " Deleted Successfully";
    });
  }
}
