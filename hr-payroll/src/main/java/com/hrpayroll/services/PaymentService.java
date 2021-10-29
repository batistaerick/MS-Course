package com.hrpayroll.services;

import com.hrpayroll.clients.WorkerFeignClient;
import com.hrpayroll.entities.Payment;
import com.hrpayroll.entities.dtos.WorkerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerClient;

    public Payment getPayment(Long workerId, Integer days) {

        WorkerDTO dto = workerClient.findById(workerId).getBody();
        return new Payment(dto.getName(), dto.getDailyIncome(), days);
    }
}