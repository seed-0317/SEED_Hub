package com.example.controllers;

import com.example.model.Interview;
import com.example.model.InterviewRatings;
import com.example.model.Question;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity postAnswer(@RequestBody InterviewRatings answer) {

        InterviewRatings answer2= businessLogic.postInterviewRatings(answer);

        if(answer2 != null) {
            return ResponseEntity.ok().body(answer2);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
