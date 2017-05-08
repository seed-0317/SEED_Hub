package com.example.controllers;

import com.example.model.Stage;
import com.example.model.StatusChange;
import com.example.model.User;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by qzh225 on 5/6/17.
 */
@RestController
@RequestMapping(value = "/statuschange")
public class StatusChangeController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value = "/{shID}", method = RequestMethod.GET)
    public ResponseEntity getStatusChange(@PathVariable("shID") int id) {
        StatusChange statusChange = businessLogic.retrieveStatusChange(id);

        if (statusChange != null) {
            return ResponseEntity.ok().body(statusChange);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllStatusChanges() {
        List<StatusChange> statusChanges = businessLogic.retrieveAllStatusChanges();

        if (statusChanges != null) {
            return ResponseEntity.ok().body(statusChanges);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value = "/user/{uId}", method = RequestMethod.GET)
    public ResponseEntity getUserStatusChanges(@PathVariable("shID") int id) {
        List<StatusChange> statusChanges = businessLogic.retrieveUserStatusChanges(id);

        if (statusChanges != null) {
            return ResponseEntity.ok().body(statusChanges);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}