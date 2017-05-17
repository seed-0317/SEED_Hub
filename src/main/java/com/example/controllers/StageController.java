package com.example.controllers;

import com.example.model.Role;
import com.example.model.Stage;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/stage")
public class StageController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value = "/{sID}", method = RequestMethod.GET)
    public ResponseEntity getStage(@PathVariable("sID") int id) {
        Stage stage = businessLogic.retrieveStage(id);

        if (stage != null) {
            return ResponseEntity.ok().body(stage);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getRole() {
        List<Stage> list = businessLogic.retrieveAllStages();

        if (list != null) {
            return ResponseEntity.ok().body(list);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
