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

    @RequestMapping(method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    //public ResponseEntity postUser(String eId, String email, String fname, String lname){
    public ResponseEntity postApplication(@RequestBody Application application){
        System.out.println("Creating application");
        System.out.println(application);

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
            return ResponseEntity.ok().body(id);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}

