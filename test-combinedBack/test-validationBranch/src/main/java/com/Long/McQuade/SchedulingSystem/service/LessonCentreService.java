package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.LessonCentre;
import com.Long.McQuade.SchedulingSystem.entities.Student;

import java.util.List;

public interface LessonCentreService {

    List<LessonCentre> findAll();

    LessonCentre findBy(int id);

    LessonCentre save(LessonCentre lessonCentre);

    String deleteByID(int id);

    public LessonCentre findByCity(String city);

}
