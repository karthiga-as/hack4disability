import { NgModule } from "@angular/core";
import { Routes, RouterModule, CanActivate } from "@angular/router";

import { DashboardComponent } from "./dashboard/dashboard.component";
import { EventComponent } from "./event/event.component";
import { PostEventTrackingComponent } from "./post-event-tracking/post-event-tracking.component";
import { ReportComponent } from "./report/report.component";
import { LoginComponent } from "./login/login.component";
import { UserComponent } from "./user/user.component";
import { VolunteerComponent } from "./volunteer/volunteer.component";
import { LandingPageComponent } from "./landing-page/landing-page.component";
import { AuthGuardService } from "./authentication/auth-guard.service";

const routes: Routes = [
  {
    path: "",
    component: LoginComponent      
  },
  {
    path: "login",
    component: LoginComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: "landingPage",
    component: LandingPageComponent,
    canActivateChild: [AuthGuardService],
    children: [
      {
        path: "user",
        component: UserComponent
      },
      {
        path: "event",
        component: EventComponent
      },
      {
        path: "volunteer",
        component: VolunteerComponent
      },
      {
        path: "postEventTracking",
        component: PostEventTrackingComponent
      },
      {
        path: "dashboard",
        component: DashboardComponent
      },
      {
        path: "report",
        component: ReportComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
