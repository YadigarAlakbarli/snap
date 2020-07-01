package com.edu.bhos.snap.userservice.controller;

import com.edu.bhos.snap.userservice.controller.abstracts.IUserController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/user-service")
public class UserController implements IUserController {

    @Value("${message}")
    private String message;


    @Override
    public String index() {
        return message;
    }
}
