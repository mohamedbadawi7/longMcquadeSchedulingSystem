package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo repo;

    @Override
    public List<Student> findAll() {

        List<Student> uneditedStudents = repo.findAll();
        List<Student> editedStudents = new ArrayList<>();

        for (Student student: uneditedStudents) {

            if (student.getStudentNumber() != null) {
                editedStudents.add(student);
            }
        }

        return editedStudents;
    }

    @Override
    public Student findBy(int id) {
        Optional<Student> result = repo.findById(id);
        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            throw new RuntimeException("Did not find student with id - " + id);
        }
        return theStudent;
    }

    @Override
    public Student save(Student student) {
        return repo.save(student);
    }

    @Override
    public String deleteByID(int id) {

        repo.deleteById(id);

        return "Student with id - " + id + " has been deleted";
    }

    @Override
    public Student findStudentByStudentNumber(String studentNumber) {
        return repo.findStudentByStudentNumber(studentNumber);
    }

    @Override
    public List<Student> findAllByExperience(String experience) {
        return repo.findAllByExperience(experience);
    }

    @Override
    public List<Student> findAllStudentsByFirstName(String firstName) {
        return repo.findAllStudentsByFirstName(firstName);
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        return repo.findStudentsByLastName(lastName);
    }


    @Override
    public List<Student> findAllByYearOfBirth(LocalDate yearOfBirth) {
        return repo.findAllByYearOfBirth(yearOfBirth);
    }


}
