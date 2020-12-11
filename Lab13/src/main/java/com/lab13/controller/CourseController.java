package com.lab13.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab13.models.Course;
import com.lab13.services.CourseService;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@GetMapping("courses")
	public ArrayList<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
}
