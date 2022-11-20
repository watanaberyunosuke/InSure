import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError, catchError } from 'rxjs';
import { map } from 'rxjs/operators';
import {Policy} from "./model/policy";

const endpoint = 'https://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class PolicyRestService {

  constructor(private http: HttpClient) { }

  // CRUD functions
  getPolicies(): Observable<any> {
    return this.http.get<Policy>(endpoint + 'policy').pipe(
      catchError(this.handleError)
    )
  }

  getProduct(id: string): Observable<any> {
    return this.http.get<Policy>(endpoint + 'policy/' + id).pipe(
      catchError(this.handleError)
    )
  }

  addPolicy(policy: any): Observable<any> {
    return this.http.post<Policy>(endpoint + 'policy', policy).pipe(
      catchError(this.handleError)
    )
  }

  updatePolicy(id: string, policy: Policy): Observable<any> {
    return this.http.put<Policy>(endpoint + 'policy/' + id, policy).pipe(
      catchError(this.handleError)
    )
  }

  deletePolicy(id: string): Observable<any> {
    return this.http.delete<Policy>(endpoint + 'policy/' + id).pipe(
      catchError(this.handleError)
    )
  }

  // ErrorEvent
  private handleError(error: HttpErrorResponse): any {

    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred: ', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, `
        + `body was: ${error.error}`);
    }
    return throwError('Something bad happened; please try again later.');
  }
}
