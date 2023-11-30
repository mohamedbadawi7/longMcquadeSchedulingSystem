package com.Long.McQuade.SchedulingSystem.controllers;


import com.Long.McQuade.SchedulingSystem.entities.Lesson;
import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.entities.Teacher;
import com.Long.McQuade.SchedulingSystem.entities.UserContacts;
import com.Long.McQuade.SchedulingSystem.exception.ErrorResponse;
import com.Long.McQuade.SchedulingSystem.exception.TeacherDoesNotExistException;
import com.Long.McQuade.SchedulingSystem.exception.TeacherUnavailableException;
import com.Long.McQuade.SchedulingSystem.service.LessonServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.StudentServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.TeacherServiceImpl;
import com.Long.McQuade.SchedulingSystem.service.UserContactsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/lessons")
@CrossOrigin(origins = "http://localhost:5173")
public class lessonController {

    @Autowired
    private LessonServiceImpl lessonService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private UserContactsServiceImpl userContactsService;

    @GetMapping("/")
    public List<Lesson> showAllLessons() {
        return lessonService.findAll();
    }

    @GetMapping("/{lessonNumber}")
    public Lesson showLessonByLessonNumber(@PathVariable("lessonNumber") String lessonNumber) {

        int id = Character.getNumericValue(lessonNumber.charAt(1));
        return lessonService.findBy(id);
    }

    @PostMapping("/new-lesson")
    public Lesson createlesson(@RequestBody Lesson lesson) throws TeacherDoesNotExistException, TeacherUnavailableException {

        String teacherNumber = lesson.getTeacherNumber();

        if (teacherService.findTeacherByTeacherNumber(teacherNumber) == null) {
            throw new TeacherDoesNotExistException();

        }

        List<Lesson> lessons = lessonService.findLessonsByTeacherNumber(teacherNumber);
        for (Lesson theLesson: lessons) {
            if (theLesson.getStartTime().equals(lesson.getStartTime())) {
                throw new TeacherUnavailableException();
            }
        }

        /* add student and teacher to each others contacts if not yet added */
        Student stud = studentService.findStudentByStudentNumber(lesson.getStudentNumber());
        Teacher teach = teacherService.findTeacherByTeacherNumber(lesson.getTeacherNumber());
        List<UserContacts> userList = userContactsService.findAllByUserNumber(stud.getStudentNumber());
        List<UserContacts> contactList = new ArrayList<>();

        /* check if already existing contacts */
        int found = 0;
        for (UserContacts userContacts : userList) {
            if (Objects.equals(userContacts.getContactUserNum(), teach.getTeacherNumber())) {
                found = 1;
                break;
            }
        }
        /* add to each others contacts if not yet added */
        if (found == 0){
            UserContacts userContacts = new UserContacts(teach.getTeacherNumber(), stud.getStudentNumber());
            UserContacts userContacts1 = new UserContacts(stud.getStudentNumber(), teach.getTeacherNumber());
            contactList.add(userContacts);
            contactList.add(userContacts1);
        }
        userContactsService.saveAll(contactList);

        lessonService.save(lesson);
        lesson.setLessonNumber("L" + lesson.getId());
        return lessonService.save(lesson);
    }

    @PutMapping("/update-lesson")
    public Lesson updateLesson(@RequestBody Lesson lesson) {

        Lesson newLesson = lessonService.save(lesson);
        return newLesson;
    }

    @DeleteMapping("/delete-lesson/{lessonNumber}")
    public String deleteLesson(@PathVariable("lessonNumber") String lessonNumber) {

        int id = Character.getNumericValue(lessonNumber.charAt(1));
        return lessonService.deleteByID(id);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(TeacherUnavailableException exc) {

        ErrorResponse errorResponse = new ErrorResponse();


        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Teacher is unavailable at this time");
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(TeacherDoesNotExistException exc) {

        ErrorResponse errorResponse = new ErrorResponse();


        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Teacher selected does not exist");
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(RuntimeException exc) {

        ErrorResponse errorResponse = new ErrorResponse();


        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage("Incorrect Data Entered for Lesson");
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
