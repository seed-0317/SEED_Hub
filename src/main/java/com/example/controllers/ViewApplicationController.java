package com.example.controllers;

import com.example.model.Application;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by uzh051 on 5/15/17.
 */

@RestController
@RequestMapping(value = "/viewapps")
public class ViewApplicationController {

    @Autowired
    private BusinessLogic businessLogic;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllApplications() {
        List<Application> applications = businessLogic.retrieveAllApplications();

        if (applications != null) {
            return ResponseEntity.ok().body(applications);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}


