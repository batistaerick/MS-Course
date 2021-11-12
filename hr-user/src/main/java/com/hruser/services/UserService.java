package com.hruser.services;

import java.util.List;
import java.util.Optional;

import com.hruser.entities.User;
import com.hruser.entities.dtos.UserDTO;
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
        Optional<User> user = repository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User save(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public Boolean validatePassword(String email, String password) {
        return encoder.matches(password, findByEmail(email).getPassword());
    }
}