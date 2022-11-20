import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Policy} from "../model/policy";

export class PolicyDataService {
  apiurl: 'api/policy';
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Accept', 'application/json');
  httpOptions = {
    headers: this.headers
  };

  constructor(private http: HttpClient) { }

  getAllPolicy(): Observable<PolicyDataService[]> {
    return this.http.get<PolicyDataService[]>(this.apiurl);
  }

  getPolicy(id: number): Observable<Policy> {
    const url = `${this.apiurl}/${id}`;
    return this.http.get<Policy>(url, this.httpOptions);
  }

  addPolicy(policy: Policy): Observable<Policy> {
    policy.policyId = null
    return this.http.post<Policy>(this.apiurl, policy, this.httpOptions)
  }

  updatePolicy(id: any, policy: Policy): Observable<Policy> {
    policy.policyId = id;
    return this.http.put<Policy>(this.apiurl, policy, this.httpOptions);
  }
}
