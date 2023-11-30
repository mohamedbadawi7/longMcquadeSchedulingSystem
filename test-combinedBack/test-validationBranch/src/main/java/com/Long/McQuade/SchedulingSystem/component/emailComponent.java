package com.Long.McQuade.SchedulingSystem.component;

import com.Long.McQuade.SchedulingSystem.notifications.EmailNotifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ScheduledFuture;

@Configuration
@EnableScheduling
public class emailComponent implements TaskScheduler {


    String cronForm;

    @Autowired
    private EmailNotifications service;

    public emailComponent() {

    }

    public emailComponent(String cronForm) {
        this.cronForm = cronForm;
    }

//    // second minute hour day month weekday
//    @Scheduled(cron = "0 12 23 * * *")
//    public void triggerMail(){
//        service.upcomingLessonReminder("mohamed.badawi@usask.ca","Student1","Teacher1"
//                ,"9:00 pm Saturday");
//
//        service.teacherCancelRequest("mohamed.badawi@usask.ca","Teacher Cancel"
//                ,"10:00 pm Saturday");
//
//        service.studentCancelRequest("mohamed.badawi@usask.ca","Student Cancel",
//                "9:00 pm Saturday");
//    }

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Trigger trigger) {
        return null;
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Instant startTime) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Instant startTime, Duration period) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Duration period) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, Instant startTime, Duration delay) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable task, Duration delay) {
        return null;
    }
}
