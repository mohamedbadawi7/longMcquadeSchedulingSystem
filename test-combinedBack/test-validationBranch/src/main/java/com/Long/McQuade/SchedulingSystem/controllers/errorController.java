package com.Long.McQuade.SchedulingSystem.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class errorController {

    @GetMapping("/error")
    public String handleError() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "User " + authentication.getName() + " does not have authorization to view this page";
    }
}
