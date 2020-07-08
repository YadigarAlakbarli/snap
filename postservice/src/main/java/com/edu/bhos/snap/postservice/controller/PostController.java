package com.edu.bhos.snap.postservice.controller;

import com.edu.bhos.snap.postservice.controller.abstracts.IPostController;
import com.edu.bhos.snap.postservice.feign.FeignClientUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post-service")
public class PostController implements IPostController {
private static final Logger LOGGER= LogManager.getLogger("postcontroller");
    @Autowired
    FeignClientUserService feignUserService;

    @Value("${message}")
    String message;

    @GetMapping("/index")
    public String index(){
        LOGGER.info("Post Service index method started");
        LOGGER.error("Post Service index method started");
     return message;
    }

    
    @GetMapping("/userindex")
    public String getDemoUser(){
        return feignUserService.index();
    }
}
