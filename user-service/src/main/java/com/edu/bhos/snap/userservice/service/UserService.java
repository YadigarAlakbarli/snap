package com.edu.bhos.snap.userservice.service;

import com.edu.bhos.snap.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
}
