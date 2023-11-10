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

import { Event } from "./event";
import { EventService } from "./event.service";
import { BaseLocation } from "../codelist/baselocation";
import { Beneficiary } from "../codelist/beneficiary";
import { Council } from "../codelist/council";
import { Project } from "../codelist/project";
import { Category } from "../codelist/category";
import { IMyDpOptions } from "mydatepicker";
import { AuthService } from "../authentication/auth.service";

@Component({
  selector: "app-event",
  templateUrl: "./event.component.html",
  styleUrls: ["./event.component.scss"]
})
export class EventComponent implements OnInit {
  @ViewChild(MdbTablePaginationComponent)
  mdbTablePagination: MdbTablePaginationComponent;

  isEventFormOpen = false;
  formTitle = "Create New Event";
  formSubmitValue = "Create";
  previous: any = [];
  data: object;
  events: Event[];
  elementVal: any = [];
  baseLocationList: BaseLocation[] = [];
  beneficiaryNameList: Beneficiary[] = [];
  firstItemIndex;
  lastItemIndex;
  elements: any = [];
  isEventDivOpen = true;
  headElements = [
    "EventTitle",
    "Baselocation",
    "BeneficiaryName",
    "EventCategory",
    "POCId",
    "EventDate",
    "EventStart",
    "EventEnd",
    "VolunteersRequired",
    "VolunteersHours"
  ];
  httpResponseMessage: string;
  councilNameList: Council[] = [];
  projectNameList: Project[] = [];
  eventCategoryList: Category[] = [];
  selectedFiles: FileList;
  currentFileUpload: File;
  result: any;

  eventStartTimeList = [
    "12.00 AM",
    "12.15 AM",
    "12.30 AM",
    "12.45 AM",
    "01.00 AM",
    "01.15 AM",
    "01.30 AM",
    "01.45 AM",
    "02.00 AM",
    "02.15 AM",
    "02.30 AM",
    "02.45 AM",
    "03.00 AM",
    "03.15 AM",
    "03.30 AM",
    "03.45 AM",
    "04.00 AM",
    "04.15 AM",
    "04.30 AM",
    "04.45 AM",
    "05.00 AM",
    "05.15 AM",
    "05.30 AM",
    "05.45 AM",
    "06.00 AM",
    "06.15 AM",
    "06.30 AM",
    "06.45 AM",
    "07.00 AM",
    "07.15 AM",
    "07.30 AM",
    "07.45 AM",
    "08.00 AM",
    "08.15 AM",
    "08.30 AM",
    "08.45 AM",
    "09.00 AM",
    "09.15 AM",
    "09.30 AM",
    "09.45 AM",
    "10.00 AM",
    "10.15 AM",
    "10.30 AM",
    "10.45 AM",
    "11.00 AM",
    "11.15 AM",
    "11.30 AM",
    "11.45 AM"
  ];

  eventEndTimeList = [
    "12.00 AM",
    "12.15 AM",
    "12.30 AM",
    "12.45 AM",
    "01.00 AM",
    "01.15 AM",
    "01.30 AM",
    "01.45 AM",
    "02.00 AM",
    "02.15 AM",
    "02.30 AM",
    "02.45 AM",
    "03.00 AM",
    "03.15 AM",
    "03.30 AM",
    "03.45 AM",
    "04.00 AM",
    "04.15 AM",
    "04.30 AM",
    "04.45 AM",
    "05.00 AM",
    "05.15 AM",
    "05.30 AM",
    "05.45 AM",
    "06.00 AM",
    "06.15 AM",
    "06.30 AM",
    "06.45 AM",
    "07.00 AM",
    "07.15 AM",
    "07.30 AM",
    "07.45 AM",
    "08.00 AM",
    "08.15 AM",
    "08.30 AM",
    "08.45 AM",
    "09.00 AM",
    "09.15 AM",
    "09.30 AM",
    "09.45 AM",
    "10.00 AM",
    "10.15 AM",
    "10.30 AM",
    "10.45 AM",
    "11.00 AM",
    "11.15 AM",
    "11.30 AM",
    "11.45 AM"
  ];

  filteredBeneficiaryNameList: any[] = [];
  filteredCouncilNameList: any[] = [];
  filteredProjectNameList: any[] = [];
  filteredCategoryNameList: any[] = [];

  constructor(
    private tableService: MdbTableService,
    private cdRef: ChangeDetectorRef,
    private router: Router,
    private eventService: EventService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.fetchTableData();
    this.eventService
      .getCodeList("baselocationlist")
      .subscribe(locationList => {
        this.baseLocationList = locationList;
      });

    this.eventService
      .getCodeList("beneficiaryList")
      .subscribe(beneficiaryList => {
        this.beneficiaryNameList = beneficiaryList;
      });

    this.eventService.getCodeList("categorylist").subscribe(categoryList => {
      this.eventCategoryList = categoryList;
    });

    this.eventService.getCodeList("councillist").subscribe(councilList => {
      this.councilNameList = councilList;
    });

    this.eventService.getCodeList("projectlist").subscribe(projectList => {
      this.projectNameList = projectList;
    });
  }

  onChangeSlidder($event) {
    return $event;
  }

  fetchTableData() {
    this.events = [];
    this.elements = [];
    this.elementVal = [];
    this.eventService.getEvents(onChangeSlidder($event)).subscribe(data => {
      this.events = data;
      this.elements.push({ data });
      for (let i = 0; i < this.elements.length; i++) {
        for (let j = 0; j < this.elements[i].data.length; j++) {
          this.elementVal.push({
            baselocation: this.elements[i].data[j].baseLocation,
            beneficiaryname: this.elements[i].data[j].beneficiaryName,
            councilname: this.elements[i].data[j].councilName,
            projectname: this.elements[i].data[j].projectName,
            eventcategory: this.elements[i].data[j].eventCategory,
            eventid: this.elements[i].data[j].eventId,
            eventtitle: this.elements[i].data[j].eventTitle,
            eventdescription: this.elements[i].data[j].eventDescription,
            eventdate: this.elements[i].data[j].eventDate,
            eventstart: this.elements[i].data[j].eventStartTime,
            eventend: this.elements[i].data[j].eventEndTime,
            volunteershours: this.elements[i].data[j].volunteershours,
            volunteersrequired: this.elements[i].data[j].volunteersRequired,
            pocid: this.elements[i].data[j].pocId,
            transporttype: this.elements[i].data[j].transportBoardingType,
            transportboardingpoint: this.elements[i].data[j]
              .transportBoardingPoints,
            transportdroppoint: this.elements[i].data[j].transportDropPoint,
            status: this.elements[i].data[j].status,
            favouriteevent: this.elements[i].data[j].isFavoriteEvent
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

  myDatePickerOptions: IMyDpOptions = {
    dateFormat: "dd/mm/yyyy"
  };

  openEventForm() {
    this.isEventFormOpen = !this.isEventFormOpen;
  }

  onNextPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }

  onPreviousPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }

  eventForm = new FormGroup({
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
        x => (x._id = this.eventForm.controls["baseLocation"].value)
      ).baseLocationName,
      beneficiaryName: this.beneficiaryNameList.find(
        x => (x._id = this.eventForm.controls["beneficiaryName"].value)
      ).beneficiaryName,
      councilName: this.councilNameList.find(
        x => (x._id = this.eventForm.controls["councilName"].value)
      ).councilName,
      projectName: this.projectNameList.find(
        x => (x._id = this.eventForm.controls["projectName"].value)
      ).projectName,
      eventCategory: this.eventCategoryList.find(
        x => (x._id = this.eventForm.controls["eventCategory"].value)
      ).categoryName,
      eventTitle: this.eventForm.controls["eventTitle"].value,
      eventDescription: this.eventForm.controls["eventDescription"].value,
      eventDate: this.eventForm.controls["eventDate"].value.formatted,
      eventStartTime: this.eventForm.controls["eventStartTime"].value,
      eventEndTime: this.eventForm.controls["eventEndTime"].value,
      volunteersHours: this.eventForm.controls["volunteersHours"].value,
      volunteersRequired: this.eventForm.controls["volunteersRequired"].value,
      pocId: this.eventForm.controls["pocId"].value,
      transportBoardingType: this.eventForm.controls["transportType"].value,
      transportBoardingPoints: this.eventForm.controls["transportBoardingPoint"]
        .value,
      transportDropPoint: this.eventForm.controls["transportDropPoint"].value,
      link: "http://172.18.1.125:4200",
      status: "NEW",
      isFavoriteEvent: this.eventForm.controls["favouriteEvent"].value,
      createdBy: this.authService.getLoggedInUser().empId,
      updatedBy: this.authService.getLoggedInUser().empId
    } as Event;
    if (this.formSubmitValue == "Create") {
      this.eventService.saveEvent(newEvent).subscribe(eventObj => {
        if (eventObj instanceof HttpResponse) {
        }
      });
    } else {
      this.eventService.updateEvent(newEvent).subscribe(userObj => {
        this.formTitle = "Create New User";
        this.formSubmitValue = "Create";
        if (userObj instanceof HttpResponse) {
        }
      });
    }
  }

  changedata($event) {
    this.filteredBeneficiaryNameList.splice(0);
    this.filteredBeneficiaryNameList = this.beneficiaryNameList.filter(
      x => x.baseLocationId == $event.target.value
    );
  }

  changeCouncilData($event) {
    this.filteredCouncilNameList.splice(0);
    this.filteredCouncilNameList = this.councilNameList.filter(
      x => x.baseLocationId == $event.target.value
    );
  }

  changeProjectData($event) {
    this.filteredProjectNameList.splice(0);
    this.filteredProjectNameList = this.projectNameList.filter(
      x => x.councilId == $event.target.value
    );
  }

  changeCategoryData($event) {
    this.filteredCategoryNameList.splice(0);
    this.filteredCategoryNameList = this.eventCategoryList.filter(
      x => x.projectId == $event.target.value
    );
  }

  edit(event: any) {
    this.formTitle = "Update Event";
    this.formSubmitValue = "Update";
    this.openEventForm();
    this.eventForm.controls["baseLocation"].setValue(event.baselocation),
      this.eventForm.controls["beneficiaryName"].setValue(
        event.beneficiaryname
      );
    this.eventForm.controls["councilName"].setValue(event.councilname);
    this.eventForm.controls["projectName"].setValue(event.projectname);
    this.eventForm.controls["eventCategory"].setValue(event.eventcategory);
    this.eventForm.controls["eventTitle"].setValue(event.eventtitle),
      this.eventForm.controls["eventDescription"].setValue(
        event.eventdescription
      ),
      this.eventForm.controls["eventDate"].setValue(event.eventdate),
      this.eventForm.controls["eventStartTime"].setValue(event.eventstart),
      this.eventForm.controls["eventEndTime"].setValue(event.eventend),
      this.eventForm.controls["volunteersHours"].setValue(
        event.volunteershours
      ),
      this.eventForm.controls["volunteersRequired"].setValue(
        event.volunteersrequired
      ),
      this.eventForm.controls["pocId"].setValue(event.pocid),
      this.eventForm.controls["transportType"].setValue(event.transporttype),
      this.eventForm.controls["transportBoardingPoint"].setValue(
        event.transportboardingpoint
      ),
      this.eventForm.controls["transportDropPoint"].setValue(
        event.transportdroppoint
      ),
      this.eventForm.controls["favouriteEvent"].setValue(event.favouriteevent);
  }

  postAction(message: string) {
    this.fetchTableData();
    this.httpResponseMessage = message;
    this.reset();
    this.openEventForm();
  }

  reset(): void {
    this.eventForm.reset();
  }

  remove(eventId: string) {
    console.log("Remove ID!!!!" + eventId);
    this.events = this.events.filter(x => x.eventId !== eventId);
    this.eventService.deleteEvent(eventId).subscribe();
  }

  setDate(): void {
    let date = new Date();
    this.eventForm.patchValue({
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
    this.eventForm.patchValue({ eventDate: null });
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  eventDivOpen() {
    this.isEventDivOpen = !this.isEventDivOpen;
  }

  upload() {
    this.currentFileUpload = this.selectedFiles.item(0);
    this.eventService
      .uploadToService(this.currentFileUpload)
      .subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
        } else if (event instanceof HttpResponse) {
          console.log("File is completely uploaded!");
        }
      });
  }
}
