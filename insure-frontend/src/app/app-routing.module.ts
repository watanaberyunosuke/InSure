import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PolicyCrudComponent} from "./policy/policy-crud/policy-crud.component";


const routes: Routes = [
  { path: '', redirectTo: 'all-policy', pathMatch: 'full' },
  { path: 'all-policy', component: PolicyCrudComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
