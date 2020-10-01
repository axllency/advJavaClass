package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService stuService = new StudentService();
	
	//create
	@PostMapping(path = "api/v1/students")
	public Student createStudent(@RequestBody Student s) {
		return stuService.createStudent(s);
	}
	
	//read
	@GetMapping(path= "api/v1/students")
	public List<Student> readStudent() {
		return stuService.findAllStudents();
	}
	
	//update
	@PutMapping(path = "api/v1/students/{studentId}")
	public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student s) {
		stuService.updateStudent(studentId, s);
	}
	
	//delete
	@DeleteMapping(path = "api/v1/students/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId) {
		stuService.deleteStudent(studentId);
	}
}
