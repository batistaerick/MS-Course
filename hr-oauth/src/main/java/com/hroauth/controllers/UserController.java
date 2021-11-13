package com.hroauth.controllers;

import com.hroauth.entities.dtos.UserDTO;
import com.hroauth.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientUsers")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/findByEmail")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(service.findByEmail(email));
    }
}