package com.edu.bhos.snap.commentservice.service;

import com.edu.bhos.snap.commentservice.entity.Comment;
import com.edu.bhos.snap.commentservice.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    
    public Comment save(Comment comment){
       return commentRepo.saveAndFlush(comment);
    }
    
    
    public List<Comment> findByPostId(Integer postId){
        return  commentRepo.findByPostId(postId);
    }

    public List<Comment> findByAuthorId(Integer authorId){
        return  commentRepo.findByAuthorId(authorId);
    }
}
