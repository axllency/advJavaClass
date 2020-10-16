package com.lab7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab7.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
