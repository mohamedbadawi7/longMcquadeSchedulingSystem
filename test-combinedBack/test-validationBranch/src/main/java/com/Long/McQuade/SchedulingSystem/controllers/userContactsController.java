package com.Long.McQuade.SchedulingSystem.controllers;

import com.Long.McQuade.SchedulingSystem.entities.*;
import com.Long.McQuade.SchedulingSystem.exception.ErrorResponse;
import com.Long.McQuade.SchedulingSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-contacts")
@CrossOrigin(origins = "http://localhost:5173")
public class userContactsController {

    @Autowired
    private UserContactsServiceImpl userContactsService;

    @GetMapping("/")
    public List<UserContacts> showAllUserContacts() {
        return userContactsService.findAll();
    }

    @GetMapping("/{identificationNumber}")
    public List<UserContacts> showUserContactsByID(@PathVariable("identificationNumber") String identificationNumber) {

        return userContactsService.findByUserNumber(identificationNumber);
    }
}
