package com.edu.bhos.snap.commentservice.service;

import com.edu.bhos.snap.commentservice.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepos;
    
    
}
