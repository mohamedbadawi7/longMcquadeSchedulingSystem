package com.Long.McQuade.SchedulingSystem.controllers;


import com.Long.McQuade.SchedulingSystem.entities.*;
import com.Long.McQuade.SchedulingSystem.exception.ErrorResponse;
import com.Long.McQuade.SchedulingSystem.exception.MissingFieldEntryException;
import com.Long.McQuade.SchedulingSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

@RestController
@RequestMapping("/users/teachers")
@CrossOrigin(origins = "http://localhost:5173")
public class teacherController {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private AuthorityServiceImpl authorityService;

    @Autowired
    private LessonServiceImpl lessonService;

    @Autowired
    private UserContactsServiceImpl userContactsService;

    @GetMapping("/")
    public List<Teacher> showAllTeachers() {
        return teacherService.findAll();
    }

//    @GetMapping("/{id}")
//    public Teacher showTeacherByID(@PathVariable("id") int id) {
//
//        return teacherService.findBy(id);
//    }

    @GetMapping("/{teacherNumber}")
    public Teacher showTeacherByID(@PathVariable("teacherNumber") String teacherNumber) {

        return teacherService.findTeacherByTeacherNumber(teacherNumber);
    }

    @PostMapping("/add-teacher")
    public Teacher addNewTeacher(@RequestBody Teacher teacher) {

        teacherService.save(teacher);
        teacher.setTeacherNumber("T" + teacher.getId());

        User user = new User(teacher.getTeacherNumber(), teacher.getFirstName(), teacher.getLastName(), "password1234", true);
        userService.save(user);

        Authority authority = new Authority(teacher.getTeacherNumber(), "TEACHER");
        authorityService.save(authority);

        Student student = new Student(null, null, null, null, null, null, null, null);
        studentService.save(student);

        /* add admin & teachers to teachers contacts and teachers to admins & teachers contacts */
        List<User> userList = userService.findAll();
        List<UserContacts> contactList = new ArrayList<>();

        for (User userIt : userList) {
            /* don't add self */
            if (!userIt.getUserNumber().equals(teacher.getTeacherNumber())) {

                String auth = authorityService.findByIdentifierNumber(userIt.getUserNumber()).getAuthority();

                /* if userIt is an admin or teacher, add new teacher as a contact */
                if (auth.equals("ADMIN") || auth.equals("TEACHER")) {
                    UserContacts userCon = new UserContacts(userIt.getUserNumber(), teacher.getTeacherNumber());
                    UserContacts userCon2 = new UserContacts(teacher.getTeacherNumber(), userIt.getUserNumber());
                    contactList.add(userCon);
                    contactList.add(userCon2);
                }
            }
        }
        userContactsService.saveAll(contactList);

        return teacherService.save(teacher);
    }

    @PutMapping("/update-teacher")
    public Teacher updateCurrentTeacher(@RequestBody Teacher teacher) {

        Teacher newTeacher = teacherService.save(teacher);

        User oldUser = userService.findBy(teacher.getId());
        oldUser.setFirstName(newTeacher.getFirstName());
        oldUser.setLastName(newTeacher.getLastName());
        userService.save(oldUser);

        return newTeacher;
    }

    @DeleteMapping("/delete-teacher/{teacherNumber}")
    public String deleteCurrentStudent(@PathVariable("teacherNumber") String teacherNumber) {

        Teacher teacher = teacherService.findTeacherByTeacherNumber(teacherNumber);

        authorityService.deleteByID(teacher.getId());
        userService.deleteByID(teacher.getId());
        studentService.deleteByID(teacher.getId());

        List<Lesson> teacherLessons = lessonService.findLessonsByTeacherNumber(teacherNumber);

        for (Lesson lesson: teacherLessons) {
            lessonService.deleteByID(lesson.getId());
        }

        /* delete teacher from contacts of others and all its contacts */
        userContactsService.deleteByUserNumber(teacherNumber);
        userContactsService.deleteByContactUserNum(teacherNumber);


        return teacherService.deleteByID(teacher.getId());
    }

    @GetMapping("get-lessons-by-teacher/{teacherNumber}")
    public List<Lesson> findAllLessons(@PathVariable("teacherNumber") String teacherNumber) {

        List<Lesson> teacherLessons = lessonService.findLessonsByTeacherNumber(teacherNumber);

        return teacherLessons;
    }

    @ExceptionHandler
    public ResponseEntity<com.Long.McQuade.SchedulingSystem.exception.ErrorResponse> handleException(RuntimeException exc) {

        ErrorResponse errorResponse = new ErrorResponse();


        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage("Incorrect Data Entered for Teacher");
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
