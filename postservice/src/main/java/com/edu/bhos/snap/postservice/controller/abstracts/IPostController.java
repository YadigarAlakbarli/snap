package com.edu.bhos.snap.postservice.controller.abstracts;

import com.edu.bhos.snap.postservice.entity.Post;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

public interface IPostController {

    @GetMapping("/index")
    String index();


    @ApiOperation(value = "This method responsible for posth add operation")
    @PostMapping("/add")
    ResponseEntity<Post> addPost(@Valid @RequestBody Post post);

    @ApiOperation(value = "This method find post by post id")
    @GetMapping("/find/{id}")
    ResponseEntity<Post> findPostById(@PathVariable Integer id);

    @ApiOperation(value = "This method  for post deleted by id")
    @GetMapping("/delete/{id}")
    ResponseEntity<String> deletePostById(@PathVariable Integer id);

    @ApiOperation(value = "For Adding post photo")
    @PostMapping("/addphoto")
    ResponseEntity<String> updatePhoto(@RequestParam("img") MultipartFile img, HttpSession session);

    @ApiOperation(value = "Get All Post List")
    @GetMapping("getall")
    ResponseEntity<List<Post>> getAll();

    @GetMapping("/getdemo")
    ResponseEntity<Post> getDemoPost();

    @GetMapping("/addemo")
    ResponseEntity<Post> addDemoPost(@Valid @RequestBody Post post);
}
