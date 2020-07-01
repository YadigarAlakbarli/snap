package com.edu.bhos.snap.userservice.controller.abstracts;

import com.edu.bhos.snap.userservice.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {
    
    @GetMapping("/index")
    public String index();
    
    @PostMapping("/add")
    User addUser(@RequestBody User user);

    @GetMapping("/findbyid/{id}")
    User findUserById(@PathVariable Integer id);
}
