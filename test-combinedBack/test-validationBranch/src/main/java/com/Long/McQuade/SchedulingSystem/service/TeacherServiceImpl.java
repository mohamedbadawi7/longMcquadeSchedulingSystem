package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.entities.Teacher;
import com.Long.McQuade.SchedulingSystem.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepo repo;

    @Override
    public List<Teacher> findAll()
    {
        List<Teacher> uneditedTeacher = repo.findAll();
        List<Teacher> editedTeacher = new ArrayList<>();

        for (Teacher teacher: uneditedTeacher) {

            if (teacher.getTeacherNumber() != null) {
                editedTeacher.add(teacher);
            }
        }

        return editedTeacher;

    }

    @Override
    public Teacher findBy(int id) {
        Optional<Teacher> result = repo.findById(id);
        Teacher theTeacher = null;

        if (result.isPresent()) {
            theTeacher = result.get();
        }
        else {
            throw new RuntimeException("Did not find teacher with id - " + id);
        }
        return theTeacher;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return repo.save(teacher);
    }

    @Override
    public String deleteByID(int id) {

        repo.deleteById(id);

        return "Teacher with id - " + id + " has been deleted";
    }

    @Override
    public Teacher findTeacherByTeacherNumber(String teacherNumber) {
        return repo.findTeacherByTeacherNumber(teacherNumber);
    }

    @Override
    public List<Teacher> findAllByInstrumentsTaughtContaining(String instrument) {
        return repo.findAllByInstrumentsTaughtContaining(instrument);
    }

    @Override
    public List<Teacher> findTeachersByFirstName(String firstName) {
        return repo.findTeachersByFirstName(firstName);
    }

    @Override
    public List<Teacher> findTeachersByLastName(String lastName) {
        return repo.findTeachersByLastName(lastName);
    }


}
