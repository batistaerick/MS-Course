package com.hrpayroll.clients;

import com.hrpayroll.entities.dtos.WorkerDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8080", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id);
}