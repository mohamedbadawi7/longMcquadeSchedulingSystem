package com.Long.McQuade.SchedulingSystem.controllers;


import com.Long.McQuade.SchedulingSystem.entities.Lesson;
import com.Long.McQuade.SchedulingSystem.entities.Request;
import com.Long.McQuade.SchedulingSystem.entities.Teacher;
import com.Long.McQuade.SchedulingSystem.service.LessonServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.RequestServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/students")
@CrossOrigin(origins = "http://localhost:5173")
public class studentViewController {

    @Autowired
    private LessonServiceImpl lessonService;

    @Autowired
    private RequestServiceImpl requestService;

    @Autowired
    private TeacherServiceImpl teacherService;


    @GetMapping("/request-lesson-change")
    public String requestLessonChange(@RequestBody String message) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = authentication.getName();

        Request request = new Request(name, message, "PENDING");
        requestService.save(request);
        return "Request for change has been sent to admin";
    }

    @GetMapping("/view-teachers")
    public List<Teacher> viewAllTeachers() {

        return teacherService.findAll();
    }


}
