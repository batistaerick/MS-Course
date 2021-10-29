package com.hrworker.services;

import java.util.List;
import java.util.Optional;

import com.hrworker.entities.Worker;
import com.hrworker.entities.dtos.WorkerDTO;
import com.hrworker.repositories.WorkerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repository;

    public List<Worker> findAll() {
        return repository.findAll();
    }

    public Worker save(WorkerDTO dto) {
        Worker worker = new Worker();
        BeanUtils.copyProperties(dto, worker);
        return repository.save(worker);
    }

    public Worker findById(Long id) {
        Optional<Worker> optional = repository.findById(id);
        
        return optional.isPresent() ? optional.get() : null;
    }
}