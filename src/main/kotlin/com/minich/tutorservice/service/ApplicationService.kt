package com.minich.tutorservice.service

import com.minich.tutorservice.model.Lesson
import com.minich.tutorservice.model.Student
import com.minich.tutorservice.model.StudyModule
import com.minich.tutorservice.model.Topic
import com.minich.tutorservice.repository.LessonRepoJpa
import com.minich.tutorservice.repository.StudentRepoJpa
import com.minich.tutorservice.repository.StudyModuleRepoJpa
import com.minich.tutorservice.repository.TopicRepoJpa
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ApplicationService(
    private val studyModuleRepoJpa: StudyModuleRepoJpa,
    private val topicRepoJpa: TopicRepoJpa,
    private val studentRepoJpa: StudentRepoJpa,
    private val lessonRepoJpa: LessonRepoJpa
) {
    @Transactional
    fun addStudyModule(studyModule: StudyModule) =
        studyModuleRepoJpa.save(studyModule)

    @Transactional
    fun deleteStudyModel(studyModule: StudyModule) =
        studyModuleRepoJpa.delete(studyModule)

    @Transactional
    fun renameStudyModule(moduleId: Long, newName: String): StudyModule? {
        return studyModuleRepoJpa.findById(moduleId)
            .map { module ->
                module.name = newName
                studyModuleRepoJpa.save(module)
            }
            .orElse(null)
    }

    @Transactional
    fun getAllStudyModules() =
        studyModuleRepoJpa.findAll()

    @Transactional
    fun addTopicToStudyModule(moduleId: Long, topic: Topic): Topic? {
        return studyModuleRepoJpa.findById(moduleId)
            .map { studyModule ->
                topic.studyModule = studyModule
                topicRepoJpa.save(topic)
            }.orElse(null)
    }

    @Transactional
    fun addTopicListToStudyModule(moduleId: Long, topicList: List<Topic>): List<Topic>? {
        return studyModuleRepoJpa.findById(moduleId)
            .map { studyModule ->
                topicList.forEach { it.studyModule = studyModule }
                topicRepoJpa.saveAll(topicList)
            }.orElse(null)
    }

    @Transactional
    fun deleteTopic(topic: Topic) =
        topicRepoJpa.delete(topic)

    @Transactional
    fun renameTopic(topicId: Long, newName: String): Topic? {
        return topicRepoJpa.findById(topicId)
            .map { topic ->
                topic.name = newName
                topicRepoJpa.save(topic)
            }.orElse(null)
    }

    @Transactional
    fun getAllTopics(): MutableList<Topic> = topicRepoJpa.findAll()

    @Transactional
    fun getTopicById(id: Long) = topicRepoJpa.findById(id).get()

    @Transactional
    fun addStudent(student: Student) =
        studentRepoJpa.save(student)

    @Transactional
    fun deleteStudent(student: Student) =
        studentRepoJpa.delete(student)

    @Transactional
    fun updateStudent(studentId: Long, updatedStudent: Student): Student? {
        return studentRepoJpa.findById(studentId)
            .map { existingStudent ->
                existingStudent.apply {
                    name = updatedStudent.name
                    lastname = updatedStudent.lastname
                    email = updatedStudent.email
                    city = updatedStudent.city
                    password = updatedStudent.password
                    registrationDate = updatedStudent.registrationDate
                    birthday = updatedStudent.birthday
                    telegram = updatedStudent.telegram
                    coveredTopics = updatedStudent.coveredTopics
                    lessons = updatedStudent.lessons
                }
                studentRepoJpa.save(existingStudent)
            }.orElse(null)
    }

    @Transactional
    fun getAllStudents(): List<Student> = studentRepoJpa.findAll()

    @Transactional
    fun getStudentById(studentId: Long): Student=studentRepoJpa.findById(studentId).get()

    @Transactional
    fun addLesson(lesson: Lesson, topicId: Long, studentIds: List<Long>): Lesson? {
        return topicRepoJpa.findById(topicId)
            .map { topic ->
                lesson.topic = topic
                studentIds.mapNotNull { studentRepoJpa.findById(it).orElse(null) }
                    .forEach { lesson.students.add(it) }
                lessonRepoJpa.save(lesson)
            }.orElse(null)
    }

    @Transactional
    fun getStudyModuleById(id:Long) = studyModuleRepoJpa.findById(id).get()
}