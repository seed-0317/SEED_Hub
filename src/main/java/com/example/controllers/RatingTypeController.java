package com.example.controllers;


import com.example.model.Question;
import com.example.model.RatingType;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ratingtype")
public class RatingTypeController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getRatingType(@PathVariable("id") int id) {
        RatingType ratingType = businessLogic.retrieveRatingType(id);

        if(ratingType != null) {
            return ResponseEntity.ok().body(ratingType);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity getAllRatingTypes() {
        List<RatingType> ratingTypes = businessLogic.retrieveAllRatingTypes();

        if(ratingTypes != null) {
            return ResponseEntity.ok().body(ratingTypes);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
