package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.LessonCentre;
import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.repositories.LessonCentreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonCentreImpl implements LessonCentreService{

    @Autowired
    private LessonCentreRepo repo;

    @Override
    public List<LessonCentre> findAll() {
        return repo.findAll();
    }

    @Override
    public LessonCentre findBy(int id) {
        Optional<LessonCentre> result = repo.findById(id);
        LessonCentre theLessonCentre = null;

        if (result.isPresent()) {
            theLessonCentre = result.get();
        }
        else {
            throw new RuntimeException("Did not find Lesson Centre with id - " + id);
        }
        return theLessonCentre;
    }

    @Override
    public LessonCentre save(LessonCentre lessonCentre) {
        return repo.save(lessonCentre);
    }

    @Override
    public String deleteByID(int id) {

        repo.deleteById(id);
        return "Lesson Centre with id - " + id + " has been deleted";
    }

    @Override
    public LessonCentre findByCity(String city) {
        return repo.findByCity(city);
    }
}
