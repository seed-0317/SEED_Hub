package com.example.controllers;

import com.example.model.Role;
import com.example.model.SeedClass;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/seedclass")
public class SeedClassController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value = "/{cId}", method = RequestMethod.GET)
    public ResponseEntity getSeedClass(@PathVariable("cId") int id) {
        SeedClass seedClass = businessLogic.retrieveSeedClass(id);

        if (seedClass != null) {
            return ResponseEntity.ok().body(seedClass);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllSeedClass() {
        List<SeedClass> seedClass = businessLogic.retrieveAllSeedClass();

        if (seedClass != null) {
            return ResponseEntity.ok().body(seedClass);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity postSeedClass(@RequestBody SeedClass newSeedClass) {
        SeedClass seedClass = businessLogic.seedClass(newSeedClass);

        if (seedClass != null) {
            return ResponseEntity.ok().body(seedClass);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
