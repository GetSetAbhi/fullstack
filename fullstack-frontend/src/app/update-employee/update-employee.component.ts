import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Observable, pipe} from 'rxjs';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
    selector: 'app-update-employee',
    templateUrl: './update-employee.component.html',
    styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

    employee$: Observable<Employee>;
    employeeId: number;

    @ViewChild("f")
    form: NgForm;

    constructor(private route: ActivatedRoute, 
        private employeeService: EmployeeService, 
        private router: Router) { }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            let id = params.get("id");
            this.employeeId = parseInt(id);
            this.employee$ = this.employeeService.getEmployee(this.employeeId);
        });
    }

    onUpdate(): void {
        if(this.form.valid) {
            console.log(this.form);
            let name = this.form.form.value.name;
            let disignation = this.form.form.value.designation;
            let employee: Employee = new Employee(name, disignation);
            employee.id = this.employeeId;
            this.employeeService.updateEmployee(employee).subscribe(data=>{
                this.router.navigate(["employees"]);
            });
        } else {
            console.log("Form is innvalid");
        }
    }

}
