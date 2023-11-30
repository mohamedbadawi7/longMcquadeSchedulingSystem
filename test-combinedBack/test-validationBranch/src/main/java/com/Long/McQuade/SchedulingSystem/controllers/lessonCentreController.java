package com.Long.McQuade.SchedulingSystem.controllers;


import com.Long.McQuade.SchedulingSystem.entities.LessonCentre;
import com.Long.McQuade.SchedulingSystem.exception.ErrorResponse;
import com.Long.McQuade.SchedulingSystem.service.LessonCentreImpl;
import com.Long.McQuade.SchedulingSystem.service.LessonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson-centres")
@CrossOrigin(origins = "http://localhost:5173")
public class lessonCentreController {

    @Autowired
    LessonCentreImpl lessonCentreService;

    @GetMapping("/")
    public List<LessonCentre> findAllCentres() {

        return lessonCentreService.findAll();
    }

    @GetMapping("/{id}")
    public LessonCentre findByID(@PathVariable("id") int id) {

        return lessonCentreService.findBy(id);
    }

    @PostMapping("/add-centre")
    public LessonCentre addCentre(@RequestBody LessonCentre lessonCentre) {

        return lessonCentreService.save(lessonCentre);
    }

    @PutMapping("/update-centre")
    public LessonCentre updateCentre(@RequestBody LessonCentre lessonCentre) {

        LessonCentre lessonCentre1 = lessonCentreService.save(lessonCentre);
        return lessonCentre1;
    }

    @DeleteMapping("/delete-centre/{id}")
    public String deleteCentre(@PathVariable("id") int id) {

        return lessonCentreService.deleteByID(id);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(RuntimeException exc) {

        ErrorResponse errorResponse = new ErrorResponse();


        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage("Incorrect Data Entered for Lesson Centre");
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
