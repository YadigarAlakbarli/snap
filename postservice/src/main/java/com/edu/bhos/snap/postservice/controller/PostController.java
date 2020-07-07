package com.edu.bhos.snap.postservice.controller;

import com.edu.bhos.snap.postservice.controller.abstracts.IPostController;
import com.edu.bhos.snap.postservice.feign.FeignClientUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post-service")
public class PostController implements IPostController {
private static final Logger LOGGER= LoggerFactory.getLogger(PostController.class);
    @Autowired
    FeignClientUserService feignUserService;

    @Value("${message}")
    String message;

    @GetMapping("/index")
    public String index(){
        LOGGER.info("Post Service index method started");
     return message;
    }

    
    @GetMapping("/userindex")
    public String getDemoUser(){
        return feignUserService.index();
    }
}
