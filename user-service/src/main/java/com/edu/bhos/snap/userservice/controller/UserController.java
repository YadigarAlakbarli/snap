package com.edu.bhos.snap.userservice.controller;

import com.edu.bhos.snap.userservice.controller.abstracts.IUserController;
import com.edu.bhos.snap.userservice.entity.User;
import com.edu.bhos.snap.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<User> addUser(User user) {
        System.out.println(user);
        return null; //ResponseEntity.ok(userService.addUser(user));
    }

    @Override
    public ResponseEntity<User> findUserById(Integer id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping("getuser")
    public User getUser(){
        User user=new User();
        user.setActive(true);
        user.setEmail("yadigar.alakbarli@gmail.com");
        user.setFirstName("Yadigar");
        user.setLastName("Elekberli");
        user.setImg(null);
        user.setMobile("050 420 23 18");
        user.setInfo("No Info");
        user.setState(true);
        return user;
    }
}
