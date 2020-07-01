package com.edu.bhos.snap.userservice.repo;

import com.edu.bhos.snap.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
}
