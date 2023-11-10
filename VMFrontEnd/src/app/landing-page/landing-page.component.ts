import { Component, OnInit } from "@angular/core";
import { AuthService } from "../authentication/auth.service";
import { AuthGuardService } from "../authentication/auth-guard.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-landing-page",
  templateUrl: "./landing-page.component.html",
  styleUrls: ["./landing-page.component.scss"]
})
export class LandingPageComponent implements OnInit {
  title = "Volunteering Marathon Application";
  currentUser;
  isMenuOpen = false;
  iscomponentDisabled: boolean = false;

  constructor(
    private authService: AuthService,
    private authGuardService: AuthGuardService,
    private router: Router
  ) {}

  ngOnInit() {
    this.currentUser = this.authService.getLoggedInUser().firstName;
    this.iscomponentDisabled = false;
  }

  toggleMenuBar() {
    this.isMenuOpen = !this.isMenuOpen;
  }

  logout() {   
    this.router.navigate([""]);
    this.authService.logoutUser();
  }
}
