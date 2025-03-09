package com.minich.tutorservice.controller

import com.minich.tutorservice.service.ApplicationService
import com.minich.tutorservice.utils.StudentIdManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController @Autowired constructor(
    private val service: ApplicationService,
    private val studentIdManager: StudentIdManager
) {

    @GetMapping("/")
//    @RequestMapping(method=[RequestMethod.GET], value =["/"])
    fun index(model: Model): String {
        model.addAttribute("topicList", service.getAllTopics())
        model.addAttribute("studentIdFromProperties", studentIdManager.studentId)
        return "index"
    }
}