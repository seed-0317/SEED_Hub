package com.example.service;

import com.example.model.Application;
import com.example.repositories.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BusinessLogic {

    @Autowired
    private ApplicationRepo applicationRepo;

    public Application retrieveApplication(int id) {
        return ApplicationRepo.findByuid(id);
    }


    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee retrieveEmployee(String name) {
        return employeeRepo.findByName(name);
    }

}
