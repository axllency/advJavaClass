package com.lab9.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab9.models.Course;
import com.lab9.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	public ArrayList<Course> getAllCourses() {
		return (ArrayList<Course>)courseRepository.findAll();
	}
}
