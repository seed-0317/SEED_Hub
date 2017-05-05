package com.example.controllers;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qzh225 on 5/5/17.
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value = "/{rID}", method = RequestMethod.GET)
    public ResponseEntity getRole(@PathVariable("rID") int id) {
        Role role = businessLogic.retrieveRole(id);

        if (role != null) {
            return ResponseEntity.ok().body(role);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
