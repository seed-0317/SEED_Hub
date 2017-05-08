package com.example.controllers;

import com.example.model.User;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    //public ResponseEntity postUser(String eId, String email, String fname, String lname){
    public ResponseEntity postUser(@RequestBody User newUser){
        System.out.println("Creating user");
        System.out.println(newUser);
        //User user = businessLogic.createUser(eId, email, fname, lname);
        User user = businessLogic.createUser(newUser);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/{eId}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("eId") String eId) {
        System.out.println("Retrieving user");
        User user = businessLogic.retrieveUser(eId);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}