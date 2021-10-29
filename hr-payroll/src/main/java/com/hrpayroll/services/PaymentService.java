package com.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import com.hrpayroll.entities.Payment;
import com.hrpayroll.entities.dtos.WorkerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    private static String workerHost = "http://localhost:8080";

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, Integer days) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + workerId);

        WorkerDTO dto = restTemplate.getForObject(workerHost + "/workers/findById/{id}", WorkerDTO.class, uriVariables);
        return new Payment(dto.getName(), dto.getDailyIncome(), days);
    }
}