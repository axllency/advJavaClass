package com.midterm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midterm.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
