package com.edu.bhos.snap.feignclient.controller;

import com.edu.bhos.snap.feignclient.feign.FUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController  {

    @Autowired
    FUserService fUserService;

    @GetMapping("/index")
    public String index() {
        return fUserService.index();
    }
}
