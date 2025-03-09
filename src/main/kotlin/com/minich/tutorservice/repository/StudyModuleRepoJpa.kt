package com.minich.tutorservice.repository

import com.minich.tutorservice.model.StudyModule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyModuleRepoJpa: JpaRepository<StudyModule, Long>