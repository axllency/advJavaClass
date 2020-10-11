package com.lab6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab6.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
