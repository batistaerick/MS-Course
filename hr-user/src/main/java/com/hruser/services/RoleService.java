package com.hruser.services;

import java.util.Optional;

import com.hruser.entities.Role;
import com.hruser.entities.dtos.RoleDTO;
import com.hruser.exceptions.RoleException;
import com.hruser.repositories.RoleRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Role findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RoleException("Role not found!"));
    }

    public Role save(RoleDTO dto) {
        return repository.save(dtoToEntity(dto));
    }

    public Role dtoToEntity(RoleDTO dto) {
        Role entity = new Role();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}