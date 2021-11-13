package com.hroauth.clients;

import com.hroauth.entities.dtos.UserDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserClient {
    
    @GetMapping(value = "/findByEmail/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email);
}