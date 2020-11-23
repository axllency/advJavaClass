package com.lab9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab9.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
