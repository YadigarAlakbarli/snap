package com.edu.bhos.snap.userservice.service;


import com.edu.bhos.snap.userservice.entity.User;
import com.edu.bhos.snap.userservice.exception.UserNotFoundEx;
import com.edu.bhos.snap.userservice.repo.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER= LogManager.getLogger("userservice");

    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundEx("User not found with id=" + id));
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        return user;
    }

    public boolean updatePhoto(MultipartFile img, Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundEx("User not found with id=" + id));
        try {
            user.setImg(img.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        user = userRepository.saveAndFlush(user);
        return true;
    }

    public boolean deleteUserById(Integer id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return true;
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        findUserById(user.getId());
        return userRepository.saveAndFlush(user);
    }
}
