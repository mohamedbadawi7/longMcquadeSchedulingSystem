package com.Long.McQuade.SchedulingSystem.controllers;

import com.Long.McQuade.SchedulingSystem.entities.Request;
import com.Long.McQuade.SchedulingSystem.service.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class adminViewController {

    @Autowired
    private RequestServiceImpl requestService;


    @GetMapping("/requests")
    public List<Request> getAllRequests() {

        return requestService.findAll();
    }

    @GetMapping("/pending-requests")
    public List<Request> getPendingRequests() {

        return requestService.findRequestsByStatus("PENDING");
    }

    @DeleteMapping("/delete-request/{id}")
    public String deleteRequest(@PathVariable("id") int id) {

        return requestService.deleteByID(id);
    }

}
