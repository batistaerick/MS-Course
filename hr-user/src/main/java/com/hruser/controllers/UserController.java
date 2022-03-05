package com.hruser.controllers;

import java.util.List;

import com.hruser.entities.User;
import com.hruser.entities.dtos.UserDTO;
import com.hruser.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/validate")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String email, @RequestParam String password) {
        return Boolean.TRUE.equals(service.validatePassword(email, password))
                ? ResponseEntity.status(HttpStatus.OK).body(true)
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/findByEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<User> save(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}