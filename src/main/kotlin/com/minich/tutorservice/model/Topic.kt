package com.minich.tutorservice.model

import jakarta.persistence.*

@Entity
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,

    var name: String,

    @ManyToMany(mappedBy = "coveredTopics", cascade = [(CascadeType.ALL)])
    val students: List<Student>,

    @ManyToOne(cascade = [CascadeType.ALL])
    var studyModule: StudyModule,

    @OneToMany(mappedBy = "topic", cascade = [(CascadeType.ALL)])
    val lessons: List<Lesson>
)
