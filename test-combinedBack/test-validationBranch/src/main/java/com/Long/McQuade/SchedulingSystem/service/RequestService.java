package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Request;
import com.Long.McQuade.SchedulingSystem.entities.Student;

import java.util.List;

public interface RequestService {

    List<Request> findAll();

    Request findBy(int id);

    Request save(Request request);

    String deleteByID(int id);

    public List<Request> findRequestsByIdentificationNumber(String identificationNumber);

    public List<Request> findRequestsByStatus(String status);
}
