package com.hrworker.controllers;

import java.util.List;

import com.hrworker.entities.Worker;
import com.hrworker.entities.dtos.WorkerDTO;
import com.hrworker.services.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService service;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Worker> save(@RequestBody WorkerDTO worker) {
        return ResponseEntity.ok(service.save(worker));
    }
}