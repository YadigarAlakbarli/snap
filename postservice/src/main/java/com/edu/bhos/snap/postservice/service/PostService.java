package com.edu.bhos.snap.postservice.service;

import com.edu.bhos.snap.postservice.entity.Post;
import com.edu.bhos.snap.postservice.exception.PostNotFoundEx;
import com.edu.bhos.snap.postservice.repo.PostRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    private static final Logger LOGGER= LogManager.getLogger("postservice");

    public Post addPost(Post post) {
        return postRepository.saveAndFlush(post);
    }

    public Post findPostById(Integer id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundEx("Post not found with id=" + id));
    }



    public boolean updatePhoto(MultipartFile img, Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundEx("Post not found with id=" + id));
        try {
            post.setImg(img.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        post = postRepository.saveAndFlush(post);
        return true;
    }

    public boolean deletePostById(Integer id) {
        Post post = findPostById(id);
        postRepository.delete(post);
        return true;
    }


    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post updatePost(Post post) {
        findPostById(post.getId());
        return postRepository.saveAndFlush(post);
    }
}
