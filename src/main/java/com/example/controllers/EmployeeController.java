package com.example.controllers;

import com.example.model.Employee;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public ResponseEntity getEmployee(@PathVariable("name") String name) {
        Employee employee = businessLogic.retrieveEmployee(name);

        if(employee != null) {
            return ResponseEntity.ok().body(employee);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
