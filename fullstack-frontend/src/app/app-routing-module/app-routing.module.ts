import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from '../employee-list/employee-list.component';
import { CreateEmployeeComponent } from '../create-employee/create-employee.component';
import { UpdateEmployeeComponent } from '../update-employee/update-employee.component';
import { ViewEmployeeComponent } from '../view-employee/view-employee.component';


const routes: Routes = [
    {path: "employees", component: EmployeeListComponent},
    {path: "create-employee", component: CreateEmployeeComponent},
    {path: "update-employee", component: UpdateEmployeeComponent},
    {path: "show-employee", component: ViewEmployeeComponent},
    {path: "", redirectTo: "/", pathMatch: "full"}
];

@NgModule({
    declarations: [],
    imports: [
        RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' }),
        CommonModule
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule { }
