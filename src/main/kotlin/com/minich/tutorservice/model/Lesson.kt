package com.minich.tutorservice.model

import jakarta.persistence.*
import java.time.LocalDate


@Entity
data class Lesson(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val date: LocalDate,

    @ManyToMany(cascade = [CascadeType.ALL])
    val students: MutableList<Student>,

    @ManyToOne(cascade = [CascadeType.ALL])
    var topic: Topic
)