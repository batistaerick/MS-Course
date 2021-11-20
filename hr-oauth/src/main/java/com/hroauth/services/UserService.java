package com.hroauth.services;

import com.hroauth.clients.UserClient;
import com.hroauth.entities.dtos.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserClient client;
    
    public UserDTO findByEmail(String email) {
        return client.findByEmail(email).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return client.findByEmail(username).getBody();
    }
}