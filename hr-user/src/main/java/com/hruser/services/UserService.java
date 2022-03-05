package com.hruser.services;

import java.util.List;
import java.util.Optional;

import com.hruser.entities.User;
import com.hruser.entities.dtos.UserDTO;
import com.hruser.exceptions.UserException;
import com.hruser.repositories.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserException("User not found!"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User save(UserDTO dto) {
        User user = dtoToEntity(dto);
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public Boolean validatePassword(String email, String password) {
        return encoder.matches(password, findByEmail(email).getPassword());
    }

    public User dtoToEntity(UserDTO dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}