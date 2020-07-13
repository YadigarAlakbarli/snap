package com.edu.bhos.snap.postservice.controller;

import com.edu.bhos.snap.postservice.controller.abstracts.IPostController;
import com.edu.bhos.snap.postservice.entity.Post;
import com.edu.bhos.snap.postservice.service.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post-service")
public class PostController implements IPostController {

    private static final Logger LOGGER = LogManager.getLogger("postcontroller");


    @Autowired
    PostService postService;

    @Value("${message}")
    private String message;

    @Override
    public ResponseEntity<Post> addPost(Post _post) {
        Post post = postService.addPost(_post);
        LOGGER.info("Post add Succesfully");
        return ResponseEntity.ok(post);
    }

    @Override
    public ResponseEntity<Post> findPostById(Integer id) {
        Post post = postService.findPostById(id);
        LOGGER.info("Find Post with id=" + id);
        return ResponseEntity.ok(post);
    }

    @Override
    public ResponseEntity<String> deletePostById(Integer id) {
        postService.deletePostById(id);
        LOGGER.info("Deleted Post which id=" + id);

        return ResponseEntity.ok("Post Deleted Sucefully");
    }

    @Override
    public ResponseEntity<String> updatePhoto(MultipartFile img, HttpSession session) {
        Integer id = (Integer) session.getAttribute("post_id");
        boolean response = postService.updatePhoto(img, id);

        return response ? ResponseEntity.ok("Post photo update succesfully") : ResponseEntity.ok("Oops");
    }

    @Override
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @Override
    public String index() {
        return message;
    }


    @Override
    public ResponseEntity<Post> getDemoPost() {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Post> addDemoPost(@Valid Post post) {
        System.out.println(post);
        return ResponseEntity.ok(post);
    }
}
