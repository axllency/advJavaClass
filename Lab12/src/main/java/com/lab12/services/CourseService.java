package com.lab12.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab12.models.Course;
import com.lab12.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	public ArrayList<Course> getAllCourses() {
		return (ArrayList<Course>)courseRepository.findAll();
	}
}
