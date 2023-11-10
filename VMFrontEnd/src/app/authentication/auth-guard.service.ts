import { Injectable } from "@angular/core";
import {
  CanActivate,
  CanActivateChild,
  Router,
  ActivatedRouteSnapshot
} from "@angular/router";
import { AuthService } from "./auth.service";

@Injectable()
export class AuthGuardService implements CanActivate, CanActivateChild {
  constructor(private authService: AuthService, private router: Router) {}
  canActivate(route: ActivatedRouteSnapshot): boolean {
    let url = this.authService.getLoginUrl();
    if (this.authService.isUserLoggedIn()) {
      return true;
    }
    this.router.navigate([url]);
    return false;
  }
  canActivateChild(route: ActivatedRouteSnapshot): boolean {
    let loggedInUser = this.authService.getLoggedInUser();
    let routeValue = route.url[0].path;

    if (loggedInUser.role === "ADMIN") {
      return true;
    } else if (
      (loggedInUser.role === "PMO" || loggedInUser.role === "EVENT POC") &&
      routeValue !== "user"
    ) {
      return true;
    } else if (loggedInUser.role === "" && routeValue !== "volunteer") {
      return true;
    } else {
      return false;
    }
  }
}
