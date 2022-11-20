import { Component, OnInit } from '@angular/core';
import { Policy } from "../model/policy";
import { PolicyDataService } from "../dataService/policyDataService";
import {FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-policy-crud',
  templateUrl: './policy-crud.component.html',
  styleUrls: ['./policy-crud.component.css']
})
export class PolicyCrudComponent implements OnInit {

  title = 'InSure'
  policies: PolicyDataService[] = []
  policyFormGroup!: FormGroup;
  policy: Policy;
  isUpdate: boolean = false;

  constructor(private policyDataService: PolicyDataService) {
    this.policy = new Policy();
  }

  ngOnInit(): void {
    this.policyFormGroup = new FormGroup(
      {
        policyName: new FormControl(''),
        power : new FormControl('')
      },
    );
  }

}
