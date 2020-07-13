package com.edu.bhos.snap.commentservice.controller;

import com.edu.bhos.snap.commentservice.controller.abstracts.ICommentController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/comment-service")
public class CommentController implements ICommentController {
    @Value("${message}")
    private String message;

    @Override
    public String index() {
        return message;
    }
}
