import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../services/EmployeeService';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private employeeService: EmployeeService) { }
  employees: [];

  ngOnInit(): void {
    this.employeeService.findAllEmployees()
      .then(employees => this.employees = employees);
  }

}
