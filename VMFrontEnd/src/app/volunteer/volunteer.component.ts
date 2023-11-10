import {
  MdbTablePaginationComponent,
  MdbTableService
} from "angular-bootstrap-md";

import {
  Component,
  OnInit,
  ViewChild,
  HostListener,
  AfterViewInit,
  ChangeDetectorRef
} from "@angular/core";

import { HttpResponse, HttpEventType } from "@angular/common/http";

import { Router } from "@angular/router";
import { FormGroup, FormControl, Validators } from "@angular/forms";

import { Event } from "../event/event";
import { EventService } from "../event/event.service";
import { BaseLocation } from "../codelist/baselocation";
import { Beneficiary } from "../codelist/beneficiary";
import { Council } from "../codelist/council";
import { Project } from "../codelist/project";
import { Category } from "../codelist/category";
import { IMyDpOptions } from "mydatepicker";

@Component({
  selector: "app-volunteer",
  templateUrl: "./volunteer.component.html",
  styleUrls: ["./volunteer.component.scss"]
})
export class VolunteerComponent implements OnInit {
  @ViewChild(MdbTablePaginationComponent)
  mdbTablePagination: MdbTablePaginationComponent;

  isVolunteerFormOpen = false;
  isVolunteerTableOpen = false;
  formTitle = "Register New Event";
  formSubmitValue = "Register";
  previous: any = [];
  data: object;
  events: Event[];
  elementVal: any = [];
  baseLocationList: BaseLocation[] = [];
  beneficiaryNameList: Beneficiary[] = [];
  firstItemIndex;
  lastItemIndex;
  elements: any = [];
  headElements = [
    "EventTitle",
    "Baselocation",
    "BeneficiaryName",
    "EventCategory",
    "POCId",
    "EventDate",
    "EventStart",
    "EventEnd",
    "VolunteersCount",
    "Status"
  ];

  councilNameList: Council[] = [];
  projectNameList: Project[] = [];
  eventCategoryList: Category[] = [];
  selectedFiles: FileList;
  currentFileUpload: File;
  result: any;

  eventStartTimeList = [];

  eventEndTimeList = [];

  filteredBeneficiaryNameList: any[] = [];
  filteredCouncilNameList: any[] = [];
  filteredProjectNameList: any[] = [];
  filteredCategoryNameList: any[] = [];

  constructor(
    private tableService: MdbTableService,
    private cdRef: ChangeDetectorRef,
    private router: Router,
    private eventService: EventService
  ) {}
  ngOnInit() {
    this.eventService.getEvents().subscribe(data => {
      this.events = data;
      this.elements.push({ data });
      for (let i = 0; i < this.elements.length; i++) {
        for (let j = 0; j < this.elements[i].data.length; j++) {
          this.elementVal.push({
            eventid: this.elements[i].data[j].eventId,
            eventtitle: this.elements[i].data[j].eventTitle,
            baselocation: this.elements[i].data[j].baseLocation,
            beneficiaryname: this.elements[i].data[j].beneficiaryName,
            eventcategory: this.elements[i].data[j].eventCategory,
            pocid: this.elements[i].data[j].pocId,
            eventdate: this.elements[i].data[j].eventDate,
            eventstart: this.elements[i].data[j].eventStartTime,
            eventend: this.elements[i].data[j].eventEndTime,
            volunteerscount: this.elements[i].data[j].volunteersSignedupsofar,
            status: this.elements[i].data[j].status
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

    this.eventService
      .getCodeList("baselocationlist")
      .subscribe(locationList => {
        this.baseLocationList = locationList;
      });
  }

  public myDatePickerOptions: IMyDpOptions = {
    dateFormat: "dd/mm/yyyy"
  };

  openVolunteerForm() {
    this.isVolunteerFormOpen = !this.isVolunteerFormOpen;
  }

  openVolunteerTable() {
    console.log("Value Before!!!"+this.isVolunteerTableOpen)
    this.isVolunteerTableOpen = !this.isVolunteerTableOpen;
    console.log("Value After!!!"+this.isVolunteerTableOpen)
  }

  onNextPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }

  onPreviousPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }

  baseLocationForm = new FormGroup({
    baseLocation: new FormControl("")
  });

  registerForm = new FormGroup({
    baseLocation: new FormControl(""),
    beneficiaryName: new FormControl(""),
    councilName: new FormControl(""),
    projectName: new FormControl(""),
    eventCategory: new FormControl(""),
    eventTitle: new FormControl(""),
    eventDescription: new FormControl(""),
    eventDate: new FormControl(null),
    eventStartTime: new FormControl(""),
    eventEndTime: new FormControl(""),
    volunteersHours: new FormControl(""),
    volunteersRequired: new FormControl(""),
    pocId: new FormControl(""),
    transportType: new FormControl(""),
    transportBoardingPoint: new FormControl([]),
    transportDropPoint: new FormControl(""),
    favouriteEvent: new FormControl("")
  });

  onSubmit() {
    const newEvent: Event = {
      baseLocation: this.baseLocationList.find(
        x => (x._id = this.registerForm.controls["baseLocation"].value)
      ).baseLocationName,
      beneficiaryName: this.beneficiaryNameList.find(
        x => (x._id = this.registerForm.controls["beneficiaryName"].value)
      ).beneficiaryName,
      councilName: this.councilNameList.find(
        x => (x._id = this.registerForm.controls["councilName"].value)
      ).councilName,
      projectName: this.projectNameList.find(
        x => (x._id = this.registerForm.controls["projectName"].value)
      ).projectName,
      eventCategory: this.eventCategoryList.find(
        x => (x._id = this.registerForm.controls["eventCategory"].value)
      ).categoryName,
      eventTitle: this.registerForm.controls["eventTitle"].value,
      eventDescription: this.registerForm.controls["eventDescription"].value,
      eventDate: this.registerForm.controls["eventDate"].value.formatted,
      eventStartTime: this.registerForm.controls["eventStartTime"].value,
      eventEndTime: this.registerForm.controls["eventEndTime"].value,
      volunteersHours: this.registerForm.controls["volunteersHours"].value,
      volunteersRequired: this.registerForm.controls["volunteersRequired"]
        .value,
      pocId: this.registerForm.controls["pocId"].value
    } as Event;
    this.eventService
      .saveEvent(newEvent)
      .subscribe(eventObj => this.events.push(eventObj));
  }

  changedata($event) {
    this.openVolunteerTable();
  }

  register(event: any) {
    console.log("Edited ID!!!!" + event.eventid);
    this.formTitle = "Update Event";
    this.formSubmitValue = "Update";
    this.openVolunteerForm();
    console.log("Event Form" + this.registerForm);
    this.registerForm.controls["eventTitle"].setValue(event.eventid);
  }

  remove(eventId: string) {
    console.log("Remove ID!!!!" + eventId);
    this.events = this.events.filter(x => x.eventId !== eventId);
    this.eventService.deleteEvent(eventId).subscribe();
  }

  setDate(): void {
    let date = new Date();
    this.registerForm.patchValue({
      eventDate: {
        date: {
          year: date.getFullYear(),
          month: date.getMonth() + 1,
          day: date.getDate()
        }
      }
    });
  }

  clearDate(): void {
    // Clear the date using the patchValue function
    this.registerForm.patchValue({ eventDate: null });
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    console.log("Value1111");
    this.currentFileUpload = this.selectedFiles.item(0);
    this.eventService
      .uploadToService(this.currentFileUpload)
      .subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          console.log("Upload!!!");
        } else if (event instanceof HttpResponse) {
          console.log("File is completely uploaded!");
        }
      });
  }
}
