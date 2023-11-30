package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.LessonCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LessonCentreRepo extends JpaRepository<LessonCentre, Integer> {

    public LessonCentre findByCity(String city);

}
