package com.lab7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab7.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
