package com.example.controllers;

import com.example.model.Interview;
import com.example.model.InterviewRatings;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/interviewratings")
public class InterviewRatingsController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/interview/{id}", method = RequestMethod.GET)
    public ResponseEntity getApplicantInterviewRatings(@PathVariable("id") int id) {
        List<InterviewRatings> interviewRatings = businessLogic.retrieveApplicantInterviewRatings(id);

        if(interviewRatings != null) {
            return ResponseEntity.ok().body(interviewRatings);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getInterviewRatings(@PathVariable("id") int id) {
        InterviewRatings interviewRatings = businessLogic.retrieveInterviewRatings(id);

        if(interviewRatings != null) {
            return ResponseEntity.ok().body(interviewRatings);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
