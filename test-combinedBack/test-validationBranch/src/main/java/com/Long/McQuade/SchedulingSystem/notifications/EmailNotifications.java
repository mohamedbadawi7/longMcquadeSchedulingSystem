package com.Long.McQuade.SchedulingSystem.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.*;

// EmailNotifications controls an email sending service
@Service
public class EmailNotifications {

    @Autowired
    private MailSender emailSender;

    SimpleMailMessage message = new SimpleMailMessage();


    // Method to send a student or teacher an email regarding an upcoming lesson
    public Runnable upcomingLessonReminder(String to, String student, String teacher, String time) {

        message.setFrom("longandmcquadelessons@gmail.com");
        message.setTo(to);
        message.setSubject("Upcoming Lesson at Long & McQuade");
        message.setText("Reminder that " + student + " has an upcoming lesson with " + teacher + " at " + time +".");
        emailSender.send(message);
        System.out.println("Upcoming lesson mail sent.");
        return null;
    }

    // Method to send a student an email if the teacher needs to cancel a lesson
    public Runnable teacherCancelRequest(String to, String teacher, String time) {

        message.setFrom("longandmcquadelessons@gmail.com");
        message.setTo(to);
        message.setSubject(teacher + " has requested to cancel their lesson");
        message.setText(teacher + " has requested to cancel their upcoming lesson @ " + time
                        + ", this request is pending. \n"
                        + " Please call --- if you have any concerns.");
        emailSender.send(message);
        System.out.println("Teacher cancel request mail sent.");
        return null;
    }

    // Method to send a student an email if the teacher needs to cancel a lesson
    public Runnable studentCancelRequest(String to, String student, String time) {

        message.setFrom("longandmcquadelessons@gmail.com");
        message.setTo(to);
        message.setSubject(student + " has requested to cancel their lesson");
        message.setText(student + " has requested to cancel their upcoming lesson @ " + time
                + ", this request is pending. \n"
                + " Please call --- if you have any concerns.");
        emailSender.send(message);
        System.out.println("Student cancel request mail sent.");
        return null;
    }

    // Method to send a student or teacher an email regarding an updated lesson
    public Runnable updateLessonReminder(String to, String student, String teacher, String time) {

        message.setFrom("longandmcquadelessons@gmail.com");
        message.setTo(to);
        message.setSubject("Lesson Change at Long & McQuade");
        message.setText("The lesson that " + teacher + " had with " + student + " has been moved to the following time: \n" +
                time);
        emailSender.send(message);
        System.out.println("Update lesson mail sent.");
        return null;
    }

    // Method to send a student or teacher an email regarding a cancelled lesson
    public Runnable cancelLessonReminder(String to, String student, String teacher, String time) {

        message.setFrom("longandmcquadelessons@gmail.com");
        message.setTo(to);
        message.setSubject("Cancelled Lesson at Long & Mcquade");
        message.setText("The lesson that " + teacher + " had with " + student + " at " +
                        time + " has been cancelled. \n" +
                "Please phone us at --- if you have any concerns");
        emailSender.send(message);
        System.out.println("Cancel lesson mail sent.");
        return null;
    }

    // Method to send a teacher an email about their new account
    public Runnable teacherCreatedNotification(String to, String firstName, String lastName, String teacherNumber) {

        message.setFrom("longandmcquadelessons@gmail.com");
        message.setTo(to);
        message.setSubject("Welcome to Long & McQuade!");
        message.setText("Welcome " + firstName + " " + lastName + " to Long & McQuade" +
                ", we're glad to have you on the team!"
        +   "\n \n Your Teacher Number is: " + teacherNumber);
        emailSender.send(message);
        return null;
    }

    // Method to send a student an email about their new account
    public Runnable studentCreatedNotification(String to, String firstName, String lastName, String studentNumber) {

        message.setFrom("longandmcquadelessons@gmail.com");
        message.setTo(to);
        message.setSubject("Welcome to Long & McQuade!");
        message.setText("Welcome " + firstName + " " + lastName + " to Long & McQuade" +
                ", we're glad to have you on the team!"
                +   "\n \n Your Student Number is: " + studentNumber);
        emailSender.send(message);
        System.out.println("Student created mail sent.");
        return null;
    }


}