package com.edu.bhos.snap.commentservice.controller.abstracts;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.List;
import com.edu.bhos.snap.commentservice.entity.Comment;

@Api(value = "All Comment operation in this Controller")
public interface ICommentController {

    @ApiOperation(value = "index endpoint return default message")
    @GetMapping("/index")
     String index();

    @ApiOperation(value = "save comment endpoind")
    @GetMapping("/save")
    ResponseEntity<Comment> save(@Valid @RequestBody Comment comment);
    
    @ApiOperation(value = "get comments by post id")
    @GetMapping("/post/{id}")
    ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Integer postId);


    @ApiOperation(value = "Get comments by Author id")
    @GetMapping("/author/{id}")
    ResponseEntity<List<Comment>> getCommentsByAuthorId(@PathVariable Integer authorId);





}
