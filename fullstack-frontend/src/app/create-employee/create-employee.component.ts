import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
    selector: 'app-create-employee',
    templateUrl: './create-employee.component.html',
    styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

    title = "Create new employee";

    @ViewChild("f")
    form: NgForm;

    constructor(private employeeService: EmployeeService, private router:Router) { }

    ngOnInit(): void {
    }

    onFormSubmit(): void {
        if(this.form.valid) {
            let name = this.form.form.value.name;
            let disignation = this.form.form.value.designation;
            let employee: Employee = new Employee(name, disignation);
            this.employeeService.createNewEmployee(employee).subscribe(data=>{
                this.router.navigate(["employees"]);
            });
        } else {
            console.log("Form is innvalid");
        }
    }

}
