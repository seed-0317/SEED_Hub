package com.example.controllers;

import com.example.model.Application;
import com.example.model.Interview;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by qzh225 on 5/5/17.
 */
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
}
