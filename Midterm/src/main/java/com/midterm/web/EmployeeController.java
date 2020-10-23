package com.midterm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midterm.models.Employee;
import com.midterm.services.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("")
	public Employee addNewEmployee(@RequestBody Employee empl) {
		return employeeService.addNewEmployee(empl);
		
	}
	
	@GetMapping("")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PatchMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee empl, @PathVariable("id") Integer id) {
		return employeeService.updateEmployee(empl, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
	}
}
