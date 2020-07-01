package com.edu.bhos.snap.userservice.controller.abstracts;

import org.springframework.web.bind.annotation.GetMapping;

public interface IUserController {
    
    @GetMapping("/")
    public String index();
}
