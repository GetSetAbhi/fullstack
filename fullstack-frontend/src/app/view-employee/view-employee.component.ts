import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
    selector: 'app-view-employee',
    templateUrl: './view-employee.component.html',
    styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {

    employee$: Observable<Employee>;

    constructor(private route: ActivatedRoute, 
        private employeeService: EmployeeService) { }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            let id = params.get("id");
            this.employee$ = this.employeeService.getEmployee(parseInt(id));
        });
    }

}
