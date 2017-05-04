package com.example.service;

import com.example.model.Application;
import com.example.model.User;
import com.example.repositories.ApplicationRepo;
import com.example.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BusinessLogic {

    @Autowired
    private ApplicationRepo applicationRepo;

    public Application retrieveApplication(int id) {
        return applicationRepo.findByuid(id);
    }




    @Autowired
    private UserRepo userRepo;

    public User retrieveUser(String eid) {
        return userRepo.findByeid(eid);
    }
}
