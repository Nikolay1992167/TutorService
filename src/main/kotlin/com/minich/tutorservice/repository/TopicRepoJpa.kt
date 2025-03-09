package com.minich.tutorservice.repository

import com.minich.tutorservice.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepoJpa: JpaRepository<Topic, Long>