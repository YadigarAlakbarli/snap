package com.edu.bhos.snap.userservice.controller;

import com.edu.bhos.snap.userservice.controller.abstracts.IUserController;
import com.edu.bhos.snap.userservice.entity.User;
import com.edu.bhos.snap.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/user-service")
public class UserController implements IUserController {

    @Autowired
    UserService userService;

    @Value("${message}")
    private String message;


    @Override
    public String index() {
        return message;
    }

    @Override
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userService.findUserById(id);
    }
    

}
