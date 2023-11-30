package com.Long.McQuade.SchedulingSystem.service;


import com.Long.McQuade.SchedulingSystem.entities.Request;
import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.repositories.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService{

    @Autowired
    private RequestRepo repo;


    @Override
    public List<Request> findAll() {
        return repo.findAll();
    }

    @Override
    public Request findBy(int id) {
        Optional<Request> result = repo.findById(id);
        Request request = null;

        if (result.isPresent()) {
            request = result.get();
        }
        else {
            throw new RuntimeException("Did not find request with id - " + id);
        }
        return request;
    }

    @Override
    public Request save(Request request) {
        return repo.save(request);
    }

    @Override
    public String deleteByID(int id) {
        repo.deleteById(id);
        return "Request has been deleted";
    }

    @Override
    public List<Request> findRequestsByIdentificationNumber(String identificationNumber) {
        return repo.findRequestsByIdentificationNumber(identificationNumber);
    }

    @Override
    public List<Request> findRequestsByStatus(String status) {
        return repo.findRequestsByStatus(status);
    }
}
