package com.lab12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab12.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
