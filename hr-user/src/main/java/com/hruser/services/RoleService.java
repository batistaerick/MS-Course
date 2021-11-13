package com.hruser.services;

import java.util.Optional;

import com.hruser.entities.Role;
import com.hruser.entities.dtos.RoleDTO;
import com.hruser.repositories.RoleRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Role findById(Long id) {
        Optional<Role> role = repository.findById(id);
        return role.isPresent() ? role.get() : null;
    }

    public Role save(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        return repository.save(role);
    }
}