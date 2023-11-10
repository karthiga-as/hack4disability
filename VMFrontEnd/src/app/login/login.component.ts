import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Global } from "../global";
import { AuthService } from "../authentication/auth.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"]
})
export class LoginComponent implements OnInit {
  title = "Volunteering Marathon Application";
  materialLoginFormEmail: string;
  materialLoginFormPassword: string;
  invalidCredentialMsg: string;
  constructor(
    private router: Router,
    private data: Global,
    private authService: AuthService
  ) {}

  ngOnInit() {}

  login(): void {
    let uname = this.materialLoginFormEmail;
    let pwd = this.materialLoginFormPassword;
    this.authService
      .isUserAuthenticated(uname, pwd)
      .subscribe(authenticated => {
        if (authenticated) {
          let loggedInUser = this.authService.getLoggedInUser();
          let url;
          if (loggedInUser.role == "ADMIN") {
            url = "landingPage/user";
          } else if (
            loggedInUser.role == "PMO" ||
            loggedInUser.role == "EVENT POC"
          ) {
            url = "landingPage/event";
          } else {
            url = "landingPage/volunteer";
          }
          this.router.navigate([url]);
        } else {
          this.invalidCredentialMsg = "Invalid Credentials. Try again.";
          this.materialLoginFormEmail = "";
          this.materialLoginFormPassword = "";
        }
      });
  }

  reset(): void {
    this.materialLoginFormEmail = "";
    this.materialLoginFormPassword = "";
  }
}
