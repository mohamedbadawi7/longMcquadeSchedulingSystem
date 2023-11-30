package com.Long.McQuade.SchedulingSystem.service;


import com.Long.McQuade.SchedulingSystem.entities.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findBy(int id);

    Student save(Student student);

    String deleteByID(int id);

    public Student findStudentByStudentNumber(String studentNumber);

    public List<Student> findAllByExperience(String experience);

    public List<Student> findAllStudentsByFirstName(String firstName);

    public List<Student> findStudentsByLastName(String lastName);

    public List<Student> findAllByYearOfBirth(LocalDate yearOfBirth);

}
