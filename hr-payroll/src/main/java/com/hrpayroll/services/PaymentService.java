package com.hrpayroll.services;

import com.hrpayroll.clients.WorkerFeignClient;
import com.hrpayroll.entities.Payment;
import com.hrpayroll.entities.dtos.WorkerDTO;

import com.hrpayroll.exceptions.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerClient;

    public Payment getPayment(Long workerId, Integer days) {

        WorkerDTO dto = workerClient.findById(workerId).getBody();
        if (dto == null) {
            throw new PaymentException("Worker not found!");
        }
        return new Payment(dto.getName(), dto.getDailyIncome(), days);
    }
}