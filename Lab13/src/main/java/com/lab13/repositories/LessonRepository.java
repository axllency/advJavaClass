package com.lab13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab13.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
