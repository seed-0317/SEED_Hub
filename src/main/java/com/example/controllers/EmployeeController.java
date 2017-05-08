package com.example.controllers;

import com.example.model.Employee;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        System.out.println(employee);

        Employee createdEmployee = businessLogic.createEmployee(employee);

        return ResponseEntity.ok(createdEmployee);
    }

}
