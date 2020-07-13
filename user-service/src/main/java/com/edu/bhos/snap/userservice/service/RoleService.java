package com.edu.bhos.snap.userservice.service;

import com.edu.bhos.snap.userservice.entity.Role;
import com.edu.bhos.snap.userservice.exception.RoleNotFoundException;
import com.edu.bhos.snap.userservice.repository.RoleRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepository;

    private static final Logger LOGGER= LogManager.getLogger("rollservice");

    public Role saveRole(Role role){
        roleRepository.saveAndFlush(role);
        LOGGER.info("new roll added");
        return role;
    }

    public Role findById(Integer id){
        return roleRepository.findById(id).orElseThrow(()->new RoleNotFoundException("Role not found with id "+id));
    }

    public Role update(Role _role){
        findById(_role.getId());
        saveRole(_role);
        return _role;
    }

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public String deleteRoleById(Integer id){
        Role role=findById(id);
        roleRepository.delete(role);
        LOGGER.info("Role deleted");
        return "Role deleted succesfully";
    }



}
