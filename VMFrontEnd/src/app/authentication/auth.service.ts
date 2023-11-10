import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import "rxjs/add/observable/of";
import "rxjs/add/operator/map";

import { HttpClient, HttpHeaders } from "@angular/common/http";

import { User } from "../user/user";
const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

@Injectable()
export class AuthService {
  private loginUrl: string = "/login";
  private isloggedIn: boolean = false;
  private loggedInUser: User;
  constructor(private http: HttpClient) {}

  private userServiceURL = "/api/userService";
  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userServiceURL + "/getUserList");
  }
  isUserAuthenticated(username: string, password: string): Observable<boolean> {
    return this.getAllUsers().map(users => {
      let user = users.find(
        user =>
          user.mailId.toLowerCase() === username && password === "pass@word1"
      );
      if (user) {
        this.isloggedIn = true;
        this.loggedInUser = user;
      } else {
        this.isloggedIn = false;
      }
      return this.isloggedIn;
    });
  }
  isUserLoggedIn(): boolean {
    return this.isloggedIn;
  }
  getLoginUrl(): string {
    return this.loginUrl;
  }
  getLoggedInUser(): User {
    return this.loggedInUser;
  }
  logoutUser(): void {
    this.isloggedIn = false;
  }
}
