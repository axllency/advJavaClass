package com.lab9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab9.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
