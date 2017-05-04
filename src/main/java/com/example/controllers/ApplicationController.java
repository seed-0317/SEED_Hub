package com.example.controllers;

import com.example.model.Application;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uzh051 on 5/4/17.
 */

@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getApplication(@PathVariable("id") int id) {
        Application application = businessLogic.retrieveApplication(id);

        if(application != null) {
            return ResponseEntity.ok().body(id);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
