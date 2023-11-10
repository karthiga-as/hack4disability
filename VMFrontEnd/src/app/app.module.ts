import { BrowserModule } from "@angular/platform-browser";
import { NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {
  MDBBootstrapModule,
  ChartsModule,
  WavesModule,
  ModalModule,
  InputsModule,
  ButtonsModule
} from "angular-bootstrap-md";
import { UiSwitchModule } from 'ngx-toggle-switch';
import { MyDatePickerModule } from "mydatepicker";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { EventComponent } from "./event/event.component";
import { PostEventTrackingComponent } from "./post-event-tracking/post-event-tracking.component";
import { ReportComponent } from "./report/report.component";
import { LoginComponent } from "./login/login.component";
import { UserComponent } from "./user/user.component";
import { VolunteerComponent } from "./volunteer/volunteer.component";
import { LandingPageComponent } from "./landing-page/landing-page.component";
import { Global } from "./global";
import { AuthGuardService } from "./authentication/auth-guard.service";
import { AuthService } from "./authentication/auth.service";

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    EventComponent,
    PostEventTrackingComponent,
    ReportComponent,
    LoginComponent,
    UserComponent,
    VolunteerComponent,
    LandingPageComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    HttpClientModule,
    ChartsModule,
    WavesModule,
    InputsModule,
    ButtonsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MyDatePickerModule,
    UiSwitchModule
  ],
  schemas: [NO_ERRORS_SCHEMA],
  providers: [Global, AuthGuardService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {}
