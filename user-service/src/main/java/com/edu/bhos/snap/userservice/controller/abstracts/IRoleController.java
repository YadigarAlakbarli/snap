package com.edu.bhos.snap.userservice.controller.abstracts;

import com.edu.bhos.snap.userservice.entity.Role;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface IRoleController {

    @ApiOperation(value = "Get Role by id")
    @GetMapping("getbyid{id}")
    ResponseEntity<Role> getById(@PathVariable Integer id);

    @ApiOperation(value = "create new role")
    @PostMapping("/add")
    ResponseEntity<String> addRole(@RequestBody Role role);

    @ApiOperation(value = "update exsist role")
    @PostMapping("/update")
    ResponseEntity<Role> updateRole(@RequestBody Role role);

    @ApiOperation(value = "Get ALL ROLS LIST")
    @GetMapping("/getall")
    ResponseEntity<List<Role>> getAllRoles();

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "Delete Role by id")
    ResponseEntity<String> deleteRoleById(@PathVariable Integer id);



}
