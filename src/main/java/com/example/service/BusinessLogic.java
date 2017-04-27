package com.example.service;

import com.example.model.Employee;
import com.example.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BusinessLogic {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee retrieveEmployee(String name) {
        return employeeRepo.findByName(name);
    }

}
