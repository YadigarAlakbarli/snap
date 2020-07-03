package com.edu.bhos.snap.userservice.service;

import com.edu.bhos.snap.userservice.entity.Role;
import com.edu.bhos.snap.userservice.exception.RoleNotFoundException;
import com.edu.bhos.snap.userservice.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role saveRole(Role role){
        roleRepository.save(role);
        return role;
    }

    public Role findById(Integer id){
        return roleRepository.findById(id).orElseThrow(()->new RoleNotFoundException("Role not found with id "+id));
    }



}
