package com.Long.McQuade.SchedulingSystem.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "lessonnum")
    private String lessonNumber;

    @NotNull(message = "Student Number cannot be empty")
    @Size(min = 2, message = "Student number must have a minimum length of two")
    @Column(name = "snum")
    private String studentNumber;

    @NotNull(message = "Teacher Number cannot be empty")
    @Size(min = 2, message = "Teacher number must have a minimum length of two")
    @Column(name = "tnum")
    private String teacherNumber;

    @NotNull(message = "Centre Number cannot be empty")
    @Size(min = 2, message = "Centre number must have a minimum length of two")
    @Column(name = "centrenum")
    private String centreID;

    @NotNull(message = "Start time cannot be empty")
    @Column(name = "starttime")
    private String startTime;

    @NotNull(message = "End time cannot be empty")
    @Column(name = "endtime")
    private String endTime;

    @NotNull(message = "Room Number cannot be empty")
    @Column(name = "roomnumber")
    private String roomNumber;

    @NotNull(message = "Date cannot be empty")
    @Column(name = "date")
    private String date;

    @NotNull(message = "Day of week cannot be empty")
    @Column(name = "dayofweek")
    private String dayOfWeek;

    public Lesson(String studentNumber, String teacherNumber, String centreID, String startTime, String endTime, String roomNumber, String date, String dayOfWeek) {
        this.studentNumber = studentNumber;
        this.teacherNumber = teacherNumber;
        this.centreID = centreID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomNumber = roomNumber;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public Lesson() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getCentreID() {
        return centreID;
    }

    public void setCentreID(String centreID) {
        this.centreID = centreID;
    }

    public String getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(String lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", centreID='" + centreID + '\'' +
                ", lessonNumber='" + lessonNumber + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", roomNumber=" + roomNumber +
                ", date='" + date + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }
}
