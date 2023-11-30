package com.Long.McQuade.SchedulingSystem.controllers;

import com.Long.McQuade.SchedulingSystem.entities.Lesson;
import com.Long.McQuade.SchedulingSystem.entities.User;
import com.Long.McQuade.SchedulingSystem.service.LessonServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.StudentServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.TeacherServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homepage")
@CrossOrigin(origins = "http://localhost:5173")
public class homepageController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private LessonServiceImpl lessonService;

    @GetMapping("/")
    public String showHomepage() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String authority = authentication.getAuthorities().iterator().next().getAuthority();

        String identificationNumber = authentication.getName();

        User user = userService.findByUserNumber(identificationNumber);

        String message = "Welcome back, " + user.getFirstName() + " " + user.getLastName() + "r\n";
        message += "Upcoming lessons: \r\n";


        switch (authority) {
            case "ADMIN":

                message += "You are an admin";
                break;

            case "TEACHER":
                List<Lesson> lessons = lessonService.findLessonsByTeacherNumber(identificationNumber);
                for (Lesson lesson: lessons) {
                    message += "Lesson on " + lesson.getDayOfWeek() + " " + lesson.getDate() + " at room " + lesson.getRoomNumber() + " with student " + studentService.findStudentByStudentNumber(lesson.getStudentNumber()).getFirstName() + "\r\n";
                }


            case "STUDENT":
                List<Lesson> lessonss = lessonService.findLessonsByStudentNumber(identificationNumber);
                for (Lesson lesson: lessonss) {
                    message += "Lesson on " + lesson.getDayOfWeek() + " " + lesson.getDate() + " at room " + lesson.getRoomNumber() + " with teacher " + teacherServiceImpl.findTeacherByTeacherNumber(lesson.getTeacherNumber()).getFirstName() + "\r\n";
                }
        }



        return message;
    }
}
