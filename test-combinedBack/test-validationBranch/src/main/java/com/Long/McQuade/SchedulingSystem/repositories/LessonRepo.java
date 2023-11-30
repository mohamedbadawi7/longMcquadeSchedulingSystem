package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Integer> {

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
