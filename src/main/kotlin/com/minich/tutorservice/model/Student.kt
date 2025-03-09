package com.minich.tutorservice.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.util.*

@Entity
data class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @field:NotBlank(message = "Name is required")
    @field:Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only letters.")
    var name: String = "",
    @field:NotBlank(message = "Lastname is required")
    @field:Pattern(regexp = "^[a-zA-Z]+$", message = "Lastname should contain only letters.")
    var lastname: String = "",
    @field:Email(message = "Invalid email address.")
    var email: String = "",
    @field:NotBlank(message = "City is required")
    var city: String = "",
    @field:NotBlank(message = "Password is required")
    var password: String = "",
    var registrationDate: Date = Date(),
    var birthday: Date = Date(),
    @field:NotBlank(message = "Telegram is required")
    var telegram: String = "",

    @ManyToMany(cascade = [CascadeType.ALL])
    var coveredTopics: MutableList<Topic> = mutableListOf(),

    @ManyToMany(cascade = [CascadeType.ALL])
    var lessons: MutableList<Lesson> = mutableListOf()
)
