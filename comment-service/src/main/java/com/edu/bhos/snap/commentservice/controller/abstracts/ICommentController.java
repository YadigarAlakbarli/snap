package com.edu.bhos.snap.commentservice.controller.abstracts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

public interface ICommentController {
    
    @GetMapping("/index")
     String index();
}
