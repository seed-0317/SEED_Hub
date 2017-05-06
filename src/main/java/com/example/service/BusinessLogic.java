package com.example.service;

import com.example.model.Application;
import com.example.model.Role;
import com.example.model.Stage;
import com.example.model.User;
import com.example.repositories.ApplicationRepo;
import com.example.repositories.RoleRepo;
import com.example.repositories.StageRepo;
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
        return applicationRepo.findByApplicantUId(id);
    }


    @Autowired
    private RoleRepo roleRepo;

    public Role retrieveRole(int rid) {
        return roleRepo.findByRId(rid);
    }

    @Autowired
    private StageRepo stageRepo;

    public Stage retrieveStage(int sid) {
        return stageRepo.findBySId(sid);
    }

    @Autowired
    private UserRepo userRepo;

    public User retrieveUser(String eid) {
        return userRepo.findByEId(eid);
    }

    public User createUser(String eid, String email, String firstName, String lastName){
        Role two = retrieveRole(2);
        Stage one = retrieveStage(1);

        User newUser= new User(eid,email,firstName,lastName,two,one);
        return userRepo.save(newUser);
    }
}
