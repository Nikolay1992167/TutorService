package com.minich.tutorservice.repository

import com.minich.tutorservice.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepoJpa: JpaRepository<Student, Long>