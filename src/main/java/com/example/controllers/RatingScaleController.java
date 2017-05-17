package com.example.controllers;

import com.example.model.RatingScale;
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
@RequestMapping(value = "/ratingscale")
public class RatingScaleController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity getAllRatingScales() {
        List<RatingScale> ratingScales = businessLogic.retrieveAllRatingScales();

        if(ratingScales != null) {
            return ResponseEntity.ok().body(ratingScales);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value="/ratingtype/{rtId}", method = RequestMethod.GET)
    public ResponseEntity getRatingScalesByRtId(@PathVariable("rtId") int rtId) {
        List<RatingScale> ratingScales = businessLogic.retrieveRatingScalesByRtId(rtId);

        if(ratingScales != null) {
            return ResponseEntity.ok().body(ratingScales);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
