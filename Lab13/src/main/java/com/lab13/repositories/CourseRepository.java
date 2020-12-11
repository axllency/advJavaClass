package com.lab13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab13.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
