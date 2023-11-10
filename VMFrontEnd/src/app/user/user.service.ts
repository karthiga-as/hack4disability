import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { User } from "./user";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

@Injectable({
  providedIn: "root"
})
export class UserService {
  constructor(private http: HttpClient) {}

  private userServiceURL = "/api/userService";
  private codeListServiceURL = "/api/codelist";

  getUsers() {
    return this.http.get<User[]>(this.userServiceURL + "/getUserList");
  }

  getCodeList(codeListName: string) {
    console.log("Fetch codeListEvent!!!!!" + codeListName);
    return this.http.get<any[]>(
      this.codeListServiceURL + "/" + codeListName,
      httpOptions
    );
  }

  saveUser(user: User): Observable<User> {
    console.log("Entered Save User!!!!!");
    return this.http.post<User>(
      this.userServiceURL + "/" + "user",
      user,
      httpOptions
    );
  }

  updateUser(user: User): Observable<User> {
    console.log("Entered Update User!!!!!");
    return this.http.put<User>(
      this.userServiceURL + "/" + "user/" + user.mailId,
      user,
      httpOptions
    );
  }

  deleteUser(mailId: String): Observable<{}> {    
    return this.http.delete(
      this.userServiceURL + "/" + "user/" + mailId,
      httpOptions
    );
  }
}
