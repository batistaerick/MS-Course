package com.hrworker.services;

import com.hrworker.entities.Worker;
import com.hrworker.entities.dtos.WorkerDTO;
import com.hrworker.exceptions.WorkerException;
import com.hrworker.repositories.WorkerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repository;

    public List<Worker> findAll() {
        return repository.findAll();
    }

    public Worker save(WorkerDTO dto) {
        return repository.save(dtoToEntity(dto));
    }

    public Worker findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new WorkerException("Worker not found!"));
    }

    public Worker dtoToEntity(WorkerDTO dto) {
        Worker entity = new Worker();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}