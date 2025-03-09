package com.minich.tutorservice.config

import com.minich.tutorservice.model.StudyModule
import com.minich.tutorservice.model.Topic
import com.minich.tutorservice.service.ApplicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TopicDataLoader @Autowired constructor(
    private val service: ApplicationService
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        service.addStudyModule(StudyModule(null, "Java language", emptyList()))
        service.addStudyModule(StudyModule(null, "Kotlin language", emptyList()))
        service.addStudyModule(StudyModule(null, "PostgreSQL DB", emptyList()))
        service.addStudyModule(StudyModule(null, "Spring framework", emptyList()))

        // Topic By module "Java language"
        service.addTopicToStudyModule(
            1L,
            Topic(null, "Syntax Java", ArrayList(), service.getStudyModuleById(1L), ArrayList())
        )
        service.addTopicToStudyModule(
            1L,
            Topic(null, "OOP", ArrayList(), service.getStudyModuleById(1L), ArrayList())
        )
        service.addTopicToStudyModule(
            1L,
            Topic(null, "Java Collections", ArrayList(), service.getStudyModuleById(1L), ArrayList())
        )
        service.addTopicToStudyModule(
            1L,
            Topic(null, "Exceptions", ArrayList(), service.getStudyModuleById(1L), ArrayList())
        )
        service.addTopicToStudyModule(
            1L,
            Topic(null, "Generics", ArrayList(), service.getStudyModuleById(1L), ArrayList())
        )
        service.addTopicToStudyModule(
            1L,
            Topic(null, "Streams", ArrayList(), service.getStudyModuleById(1L), ArrayList())
        )
        service.addTopicToStudyModule(
            1L,
            Topic(null, "Concurrent in Java", ArrayList(), service.getStudyModuleById(1L), ArrayList())
        )

        // Topic By module "Kotlin language"
        service.addTopicToStudyModule(
            2L,
            Topic(null, "Syntax Kotlin", ArrayList(), service.getStudyModuleById(2L), ArrayList())
        )
        service.addTopicToStudyModule(
            2L,
            Topic(null, "OOP", ArrayList(), service.getStudyModuleById(2L), ArrayList())
        )
        service.addTopicToStudyModule(
            2L,
            Topic(null, "Kotlin Collections", ArrayList(), service.getStudyModuleById(2L), ArrayList())
        )
        service.addTopicToStudyModule(
            2L,
            Topic(null, "Exceptions", ArrayList(), service.getStudyModuleById(2L), ArrayList())
        )
        service.addTopicToStudyModule(
            2L,
            Topic(null, "Generics", ArrayList(), service.getStudyModuleById(2L), ArrayList())
        )
        service.addTopicToStudyModule(
            2L,
            Topic(null, "Kotlin Extensions", ArrayList(), service.getStudyModuleById(2L), ArrayList())
        )
        service.addTopicToStudyModule(
            2L,
            Topic(null, "Coroutines", ArrayList(), service.getStudyModuleById(2L), ArrayList())
        )

        // Topic для PostgreSQL
        service.addTopicToStudyModule(
            3L,
            Topic(null, "Introduction to PostgreSQL", ArrayList(), service.getStudyModuleById(3L), ArrayList())
        )
        service.addTopicToStudyModule(
            3L,
            Topic(null, "PostgreSQL Data Types", ArrayList(), service.getStudyModuleById(3L), ArrayList())
        )
        service.addTopicToStudyModule(
            3L,
            Topic(null, "PostgreSQL Queries", ArrayList(), service.getStudyModuleById(3L), ArrayList())
        )
        service.addTopicToStudyModule(
            3L,
            Topic(null, "PostgreSQL Indexes", ArrayList(), service.getStudyModuleById(3L), ArrayList())
        )
        service.addTopicToStudyModule(
            3L,
            Topic(null, "PostgreSQL Joins", ArrayList(), service.getStudyModuleById(3L), ArrayList())
        )

        // Topic для Spring framework
        service.addTopicToStudyModule(
            4L,
            Topic(null, "Spring Boot Basics", ArrayList(), service.getStudyModuleById(4L), ArrayList())
        )
        service.addTopicToStudyModule(
            4L,
            Topic(null, "Spring Data JPA", ArrayList(), service.getStudyModuleById(4L), ArrayList())
        )
        service.addTopicToStudyModule(
            4L,
            Topic(null, "Spring Security", ArrayList(), service.getStudyModuleById(4L), ArrayList())
        )
        service.addTopicToStudyModule(
            4L,
            Topic(null, "Spring MVC", ArrayList(), service.getStudyModuleById(4L), ArrayList())
        )
        service.addTopicToStudyModule(
            4L,
            Topic(null, "Spring Cloud", ArrayList(), service.getStudyModuleById(4L), ArrayList())
        )

    }
}