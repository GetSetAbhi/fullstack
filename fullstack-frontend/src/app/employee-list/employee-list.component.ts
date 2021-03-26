import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
    selector: 'app-employee-list',
    templateUrl: './employee-list.component.html',
    styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

    title = 'Employee List';

    /*var employees: Employee[] = [
           { "id": 1, "name": "Abhishek", "designation": "Er" },
           { "id": 2, "name": "Abhishek", "designation": "Er" },
           { "id": 3, "name": "Abhishek", "designation": "Er" }
       ];*/

    employees: Employee[];

    constructor(private employeeService: EmployeeService, private router: Router) { }

    ngOnInit(): void {
        this.getEmployees();
    }

    updateEmployee(employee: Employee) {
        this.router.navigate(["update-employee", { id: employee.id }]);
    }

    showEmployee(id: number) {
        this.router.navigate(["show-employee", { id: id }]);
    }

    deleteEmployee(employee: Employee) {
        console.log("Deleting employee with id " + employee.id);
        this.employeeService.deleteEmployee(employee.id).subscribe(data => {
            this.getEmployees();
        });
    }

    getEmployees(): void {
        this.employeeService.getEmployees().subscribe(data => {
            this.employees = data.employees;
        });
    }

}
