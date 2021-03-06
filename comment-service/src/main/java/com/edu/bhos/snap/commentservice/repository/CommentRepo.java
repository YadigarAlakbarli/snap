package com.edu.bhos.snap.commentservice.repository;

import com.edu.bhos.snap.commentservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {
    
    List<Comment> findByPostId(Integer id);
    List<Comment> findByAuthorId(Integer id);
}
