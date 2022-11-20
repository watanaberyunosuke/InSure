import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly userUrl: string;
  private endpoint = "http://localhost:8080"

  constructor(private http: HttpClient) {
      this.userUrl = this.endpoint + "/api/users";
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl)
  }

  public findById(id: string): Observable<User> {
    return this.http.get<User>(this.userUrl + "/" + id)
  }
}
