package com.example.controllers;

import com.example.model.Application;
import com.example.model.Interview;
import com.example.model.User;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/interview")
public class InterviewController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getInterview(@PathVariable("id") int id) {
        Interview interview = businessLogic.retrieveInterview(id);

        if(interview != null) {
            return ResponseEntity.ok().body(interview);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value="/apllicant/{id}", method = RequestMethod.GET)
    public ResponseEntity getApplicantInterview(@PathVariable("id") int id) {
        List<Interview> interviews = businessLogic.retrieveApplicantInterview(id);

        if(interviews != null) {
            return ResponseEntity.ok().body(interviews);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity postInterview(@RequestBody Interview newInterview) {
        Interview interview = businessLogic.createInterview(newInterview);

        if(interview != null) {
            return ResponseEntity.ok().body(interview);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
