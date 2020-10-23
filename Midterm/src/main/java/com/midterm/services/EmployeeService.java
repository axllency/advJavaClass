package com.midterm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.models.Employee;
import com.midterm.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addNewEmployee(Employee empl) {
		// TODO Auto-generated method stub
		return employeeRepository.save(empl);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee empl, Integer id) {
		// TODO Auto-generated method stub
		if(employeeRepository.findById(id).isPresent()) {
			empl.setId(id);
			return employeeRepository.save(empl);
		} else {
			return null;
		}
	}

	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
		} 
	}
	
	
}
