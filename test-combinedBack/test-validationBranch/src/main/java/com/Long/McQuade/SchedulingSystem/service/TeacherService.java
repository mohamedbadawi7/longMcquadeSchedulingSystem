package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.entities.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findBy(int id);

    Teacher save(Teacher teacher);

    String deleteByID(int id);

    public Teacher findTeacherByTeacherNumber(String teacherNumber);

    public List<Teacher> findAllByInstrumentsTaughtContaining(String instrument);

    public List<Teacher> findTeachersByFirstName(String firstName);

    public List<Teacher> findTeachersByLastName(String lastName);
}
