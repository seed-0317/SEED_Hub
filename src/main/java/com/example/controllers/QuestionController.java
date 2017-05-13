package com.example.controllers;

import com.example.model.*;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/question")
public class QuestionController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getQuestion(@PathVariable("id") int id) {
        Question question = businessLogic.retrieveQuestion(id);

        if(question != null) {
            return ResponseEntity.ok().body(question);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value="/typeandclass/{type}/{cid}", method = RequestMethod.GET)
    public ResponseEntity getClassIntQuestions(@PathVariable("cid") int cid, @PathVariable("type") String qType ) {
        List<Question> questions = businessLogic.retrieveClassTypeQuestions(cid, qType);

        if(questions != null) {
            return ResponseEntity.ok().body(questions);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity getQuestions() {
        List<Question> questions = businessLogic.retrieveAllQuestions();


        if(questions != null) {
            return ResponseEntity.ok().body(questions);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postQuestion(@RequestBody Question question) {


        System.out.println("In QuestionController, question =" + question);
        Question question2= businessLogic.postQuestion(question);

        System.out.println("In QuestionController, question2 =" + question2);

        if(question2 != null) {
            return ResponseEntity.ok().body(question2);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
