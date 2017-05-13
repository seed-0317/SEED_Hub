package com.example.controllers;

import com.example.model.*;
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

    @RequestMapping(value="/{eId}/{SeedClass}", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity postApplication(@PathVariable("eId") String eId, @PathVariable("SeedClass") int SeedClass, @RequestBody Application newApplication){
        System.out.println("Creating application");
        System.out.println(newApplication);
        Application application = businessLogic.application(eId, SeedClass, newApplication);

        if (application != null) {
            return ResponseEntity.ok().body(application);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getApplication(@PathVariable("id") int id) {
        Application application = businessLogic.retrieveApplication(id);

        if(application != null) {
            return ResponseEntity.ok().body(application);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}



