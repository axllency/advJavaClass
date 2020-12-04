package com.lab12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab12.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
