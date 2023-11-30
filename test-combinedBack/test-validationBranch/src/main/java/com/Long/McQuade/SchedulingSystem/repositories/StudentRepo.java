package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


    public Student findStudentByStudentNumber(String studentNumber);

    public List<Student> findAllByExperience(String experience);

    public List<Student> findAllStudentsByFirstName(String firstName);

    public List<Student> findStudentsByLastName(String lastName);

    public List<Student> findAllByYearOfBirth(LocalDate yearOfBirth);

}