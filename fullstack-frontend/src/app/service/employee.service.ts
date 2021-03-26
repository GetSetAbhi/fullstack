import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { Employees } from '../model/employees';

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {

    constructor(private httpClient: HttpClient) { }

    getEmployees() {
        var url = "http://localhost:8080/api/employees";

        console.log("Hitting Url : " + url);

        return this.httpClient.get<Employees>(url);
    }

    getEmployee(id: number) {
        var url = "http://localhost:8080/api/employee/" + id;
        return this.httpClient.get<Employee>(url);
    }

    createNewEmployee(employee: Employee) {
        var url = "http://localhost:8080/api/create/employee";
        return this.httpClient.post<any>(url, employee);
    }

    updateEmployee(employee: Employee) {
        var url = "http://localhost:8080/api/employee/" + employee.id;
        return this.httpClient.put<any>(url, employee);
    }

    deleteEmployee(id: number) {
        var url = "http://localhost:8080/api/employee/" + id;
        return this.httpClient.delete<any>(url);
    }
}
