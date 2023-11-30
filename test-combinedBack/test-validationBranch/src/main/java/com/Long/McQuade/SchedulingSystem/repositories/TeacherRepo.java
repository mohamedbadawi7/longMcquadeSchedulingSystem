package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

    public Teacher findTeacherByTeacherNumber(String teacherNumber);

    public List<Teacher> findAllByInstrumentsTaughtContaining(String instrument);

    public List<Teacher> findTeachersByFirstName(String firstName);

    public List<Teacher> findTeachersByLastName(String lastName);




}
