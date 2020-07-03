package com.edu.bhos.snap.postservice.controller;

import com.edu.bhos.snap.postservice.controller.abstracts.IPostController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post-service")
public class PostController implements IPostController {

    @Value("${message}")
    String message;

    @GetMapping("/index")
    public String index(){
     return message;
    }
}
