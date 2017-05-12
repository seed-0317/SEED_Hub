package com.example.controllers;

import com.example.model.Application;
import com.example.model.User;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/{eId}", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity postApplication(@RequestBody Application newApplication){
//        User user = get
        System.out.println("Creating application");
        System.out.println(newApplication);
        Application application = businessLogic.application(newApplication);

        if (application != null) {
            return ResponseEntity.ok().body(application);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value="/{eId}", method = RequestMethod.GET)
    public ResponseEntity getApplication(@PathVariable("eId") int eId) {
        Application application = businessLogic.retrieveApplication(eId);

        if(application != null) {
            return ResponseEntity.ok().body(eId);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}

