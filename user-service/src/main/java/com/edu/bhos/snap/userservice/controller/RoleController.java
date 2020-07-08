package com.edu.bhos.snap.userservice.controller;

import com.edu.bhos.snap.userservice.controller.abstracts.IRoleController;
import com.edu.bhos.snap.userservice.entity.Role;
import com.edu.bhos.snap.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/v1/role-service")
public class RoleController implements IRoleController {
    @Autowired
    RoleService roleService;

    @Override
    public ResponseEntity<Role> getById(Integer id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @Override
    public ResponseEntity<String> addRole(Role role) {
        roleService.saveRole(role);
        return ResponseEntity.ok("Roll added succesfully");
    }

    @Override
    public ResponseEntity<Role> updateRole(Role role) {
        return ResponseEntity.ok(roleService.update(role));
    }

    @Override
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @Override
    public ResponseEntity<String> deleteRoleById(Integer id) {
        String respons = roleService.deleteRoleById(id);
        return ResponseEntity.ok(respons);
    }
}
