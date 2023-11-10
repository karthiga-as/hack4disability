import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpEvent,
  HttpRequest
} from "@angular/common/http";
import { Observable } from "rxjs";
import { catchError } from "rxjs/operators";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

import { Event } from "./event";
import { BaseLocation } from "../codelist/baselocation";
import { Beneficiary } from "../codelist/beneficiary";
import { Council } from "../codelist/council";
import { Project } from "../codelist/project";
import { Category } from "../codelist/category";

@Injectable({
  providedIn: "root"
})
export class EventService {
  private eventServiceURL = "/api/eventService";
  private codeListServiceURL = "/api/codelist";

  constructor(private http: HttpClient) {}

  getEvents() {
    console.log("URL" + this.eventServiceURL + "/" + "getEventList");
    return this.http.get<Event[]>(this.eventServiceURL + "/" + "getEventList");
  }

  saveEvent(event: Event): Observable<Event> {
    console.log("Entered Save Event!!!!!" + event.baseLocation);
    return this.http.post<Event>(
      this.eventServiceURL + "/" + "saveEvent",
      event,
      httpOptions
    );
  }

  deleteEvent(eventId: String): Observable<{}> {
    console.log("Entered Delete Event!!!!!" + eventId);
    return this.http.delete(this.eventServiceURL + "/" + eventId, httpOptions);
  }

  getCodeList(codeListName: string) {
    console.log("Fetch codeListEvent!!!!!" + codeListName);
    return this.http.get<any[]>(
      this.codeListServiceURL + "/" + codeListName,
      httpOptions
    );
  }

  uploadToService(file: File): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append("file", file);
    const req = new HttpRequest(
      "POST",
      this.eventServiceURL + "/" + "saveEventList",
      formdata,
      {
        reportProgress: true,
        responseType: "text"
      }
    );
    return this.http.request(req);
  }

  updateEvent(event: Event): Observable<Event> {
    console.log("Entered Update User!!!!!");
    return this.http.put<Event>(
      this.eventServiceURL + "/" + "event/" + event.eventId,
      event,
      httpOptions
    );
  }
}
