package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Lesson;
import com.Long.McQuade.SchedulingSystem.entities.Student;

import java.util.List;

public interface LessonService {

    List<Lesson> findAll();

    Lesson findBy(int id);

    Lesson save(Lesson lesson);

    String deleteByID(int id);

    public Lesson findByLessonNumber(String lessonNumber);

    public List<Lesson> findLessonsByStudentNumber(String studentNumber);

    public List<Lesson> findLessonsByTeacherNumber(String teacherNumber);

    public List<Lesson> findLessonsByCentreID(String centreID);

    public List<Lesson> findLessonsByStartTime(String startTime);

    public List<Lesson> findLessonsByEndTime(String endTime);

    public List<Lesson> findAllByRoomNumber(String roomNumber);

    public List<Lesson> findLessonsByDate(String date);

    public List<Lesson> findLessonsByDayOfWeek(String dayOfWeek);

    public List<Lesson> findLessonsByDateAndStartTime(String date, String startTime);

    public List<Lesson> findLessonsByStudentNumberAndTeacherNumber(String studentNumber, String teacherNumber);


}
