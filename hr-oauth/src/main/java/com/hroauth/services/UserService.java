package com.hroauth.services;

import com.hroauth.clients.UserClient;
import com.hroauth.entities.dtos.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserClient client;
    
    public UserDTO findByEmail(String email) {
        return client.findByEmail(email).getBody();
    }
}