package com.edu.bhos.snap.userservice.controller.abstracts;

import com.edu.bhos.snap.userservice.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


public interface IUserController {

    @GetMapping("/index")
    String index();


    @ApiOperation(value = "This method responsible for user add operation")
    @PostMapping("/add")
    ResponseEntity<User> addUser(@Valid @RequestBody User user);

    @ApiOperation(value = "This method find user by user id")
    @GetMapping("/findbyid/{id}")
    ResponseEntity<User> findUserById(@PathVariable Integer id);

    @GetMapping("/getdemo")
    ResponseEntity<User> getDemoUser();
    @GetMapping("/addemo")
    ResponseEntity<User> addDemoUser(@Valid @RequestBody User user);

}
