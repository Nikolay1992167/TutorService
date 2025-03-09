package com.minich.tutorservice.repository

import com.minich.tutorservice.model.Lesson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonRepoJpa:JpaRepository<Lesson, Long>