package com.Long.McQuade.SchedulingSystem.service;


import com.Long.McQuade.SchedulingSystem.entities.Lesson;
import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.repositories.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService{

    @Autowired
    private LessonRepo repo;
    @Override
    public List<Lesson> findAll() {

        return repo.findAll();
    }

    @Override
    public Lesson findBy(int id) {

        Optional<Lesson> result = repo.findById(id);
        Lesson theLesson = null;

        if (result.isPresent()) {
            theLesson = result.get();
        }
        else {
            throw new RuntimeException("Did not find lesson with id - " + id);
        }
        return theLesson;
    }

    @Override
    public Lesson save(Lesson lesson) {
        return repo.save(lesson);
    }

    @Override
    public String deleteByID(int id) {

        repo.deleteById(id);
        return "Lesson with id - " + id + " has been deleted";
    }

    @Override
    public Lesson findByLessonNumber(String lessonNumber) {
        return repo.findByLessonNumber(lessonNumber);
    }

    @Override
    public List<Lesson> findLessonsByStudentNumber(String studentNumber) {
        return repo.findLessonsByStudentNumber(studentNumber);
    }

    @Override
    public List<Lesson> findLessonsByTeacherNumber(String teacherNumber) {
        return repo.findLessonsByTeacherNumber(teacherNumber);
    }

    @Override
    public List<Lesson> findLessonsByCentreID(String centreID) {
        return repo.findLessonsByCentreID(centreID);
    }

    @Override
    public List<Lesson> findLessonsByStartTime(String startTime) {
        return repo.findLessonsByStartTime(startTime);
    }

    @Override
    public List<Lesson> findLessonsByEndTime(String endTime) {
        return repo.findLessonsByEndTime(endTime);
    }

    @Override
    public List<Lesson> findAllByRoomNumber(String roomNumber) {
        return repo.findAllByRoomNumber(roomNumber);
    }

    @Override
    public List<Lesson> findLessonsByDate(String date) {
        return repo.findLessonsByDate(date);
    }

    @Override
    public List<Lesson> findLessonsByDayOfWeek(String dayOfWeek) {
        return repo.findLessonsByDayOfWeek(dayOfWeek);
    }

    @Override
    public List<Lesson> findLessonsByDateAndStartTime(String date, String startTime) {
        return repo.findLessonsByDateAndStartTime(date, startTime);
    }

    @Override
    public List<Lesson> findLessonsByStudentNumberAndTeacherNumber(String studentNumber, String teacherNumber) {
        return repo.findLessonsByStudentNumberAndTeacherNumber(studentNumber, teacherNumber);
    }
}
