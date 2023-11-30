package com.Long.McQuade.SchedulingSystem.controllers;
import com.Long.McQuade.SchedulingSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import com.Long.McQuade.SchedulingSystem.service.UserServiceImpl;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:5173")
public class loginController {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        UserDetails userDetails = userDetailsManager.loadUserByUsername(username);

        User currentUser = userService.findByUserNumber(username);

        if (password.equals(userDetails.getPassword())) {

            return ResponseEntity.ok(Map.of("message", "Login successful", "currentUser", currentUser));
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}
