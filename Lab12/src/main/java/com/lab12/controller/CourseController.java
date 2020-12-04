package com.lab12.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab12.models.Course;
import com.lab12.services.CourseService;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@GetMapping("courses")
	public ArrayList<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
}
