package com.edu.bhos.snap.userservice.service;


import com.edu.bhos.snap.userservice.entity.User;
import com.edu.bhos.snap.userservice.exception.UserNotFoundEx;
import com.edu.bhos.snap.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public User addUser(User user){
       return userRepository.save(user);
    }

    public User findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundEx("User not found with id "+id));
    }
}
