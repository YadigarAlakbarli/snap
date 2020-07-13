package com.edu.bhos.snap.commentservice.controller;

import com.edu.bhos.snap.commentservice.controller.abstracts.ICommentController;
import com.edu.bhos.snap.commentservice.entity.Comment;
import com.edu.bhos.snap.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/v1/comment-service")
public class CommentController implements ICommentController {
    @Autowired
    CommentService commentService;
    
    @Value("${message}")
    private String message;

    @Override
    public String index() {
        return message;
    }

    @Override
    public ResponseEntity<Comment> save(@Valid Comment comment) {
        return  ResponseEntity.ok(commentService.save(comment));
    }

    @Override
    public ResponseEntity<List<Comment>> getCommentsByPostId(Integer postId) {
        return ResponseEntity.ok(commentService.findByPostId(postId));
    }

    @Override
    public ResponseEntity<List<Comment>> getCommentsByAuthorId(Integer authorId) {
        return ResponseEntity.ok(commentService.findByAuthorId(authorId));
    }
}
