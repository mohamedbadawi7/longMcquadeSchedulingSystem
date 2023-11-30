package com.Long.McQuade.SchedulingSystem.controllers;


import com.Long.McQuade.SchedulingSystem.entities.*;
import com.Long.McQuade.SchedulingSystem.exception.ErrorResponse;
import com.Long.McQuade.SchedulingSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class userController {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private AuthorityServiceImpl authorityService;

    @Autowired
    private UserContactsServiceImpl userContactsService;


    @GetMapping("/")
    public List<User> showAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{identificationNumber}")
    public User showUserByID(@PathVariable("identificationNumber") String identificationNumber) {

        return userService.findByUserNumber(identificationNumber);
    }

    @PostMapping("/add-admin")
    public User addAdmin(@RequestBody User user) {


        User newUser = new User("A" + user.getId(), user.getFirstName(), user.getLastName(), user.getPwd(), true);
        userService.save(newUser);
        newUser.setUserNumber("A" + newUser.getId());

        Authority authority = new Authority(newUser.getUserNumber(), "ADMIN");
        authorityService.save(authority);

        Student student = new Student(null, null, null, null, null, null, null, null);
        studentService.save(student);

        Teacher teacher = new Teacher(null, null, null, null, null, null, null, null);
        teacherService.save(teacher);

        /* Admin will have all users in system as a contact */
        List<User> userList = userService.findAll();
        List<UserContacts> contactList = new ArrayList<>();

        for (User userIt : userList) {
            /* don't add self */
            if (!userIt.getUserNumber().equals(newUser.getUserNumber())){
                UserContacts userContact = new UserContacts(newUser.getUserNumber(), userIt.getUserNumber());
                contactList.add(userContact);

                String auth = authorityService.findByIdentifierNumber(userIt.getUserNumber()).getAuthority();

                /* if userIt is also an admin or teacher, add new admin as a contact */
                if (auth.equals("ADMIN") || auth.equals("TEACHER")){
                    UserContacts userContact2 = new UserContacts(userIt.getUserNumber(), newUser.getUserNumber());
                    contactList.add(userContact2);
                }
            }
        }
        userContactsService.saveAll(contactList);

        return userService.save(newUser);
    }

    @PutMapping("/update-admin")
    public User updateAdmin(@RequestBody User user) {

        return userService.save(user);
    }

    @DeleteMapping("/delete-admin/{id}")
    public void deleteAdmin(@PathVariable("id") String id) {

        User user = userService.findByUserNumber(id);


        teacherService.deleteByID(user.getId());
        studentService.deleteByID(user.getId());
        authorityService.deleteByID(user.getId());
        userService.deleteByID(user.getId());

        /* delete admin contacts and those who have admin as a contact */
        userContactsService.deleteByUserNumber(id);
        userContactsService.deleteByContactUserNum(id);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(RuntimeException exc) {

        ErrorResponse errorResponse = new ErrorResponse();


        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage("Incorrect Data Entered for Admin");
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
