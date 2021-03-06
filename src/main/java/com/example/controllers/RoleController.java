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

import java.util.List;


@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private BusinessLogic businessLogic;

    @RequestMapping(value = "/{rId}", method = RequestMethod.GET)
    public ResponseEntity getRole(@PathVariable("rId") int id) {
        Role role = businessLogic.retrieveRole(id);

        if (role != null) {
            return ResponseEntity.ok().body(role);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getRole() {
        List<Role> list = businessLogic.retrieveAllRoles();

        if (list != null) {
            return ResponseEntity.ok().body(list);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
