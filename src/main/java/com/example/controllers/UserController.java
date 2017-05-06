package com.example.controllers;

import com.example.model.User;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qzh225 on 5/5/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postUser(String eId, String email, String fname, String lname){

        User user = businessLogic.createUser(eId, email, fname, lname);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/{eid}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("eid") String id) {
        User user = businessLogic.retrieveUser(id);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}