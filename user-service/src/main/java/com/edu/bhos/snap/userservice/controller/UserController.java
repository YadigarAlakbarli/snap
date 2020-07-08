package com.edu.bhos.snap.userservice.controller;

import com.edu.bhos.snap.userservice.controller.abstracts.IUserController;
import com.edu.bhos.snap.userservice.entity.Role;
import com.edu.bhos.snap.userservice.entity.User;
import com.edu.bhos.snap.userservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/v1/user-service")
@Log4j2
public class UserController implements IUserController {


    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${message}")
    private String message;


    @Override
    public String index() {
        return message;
    }

    @Override
    public ResponseEntity<User> addUser(User user) {

        return ResponseEntity.ok(userService.addUser(user));
    }

    @Override
    public ResponseEntity<User> findUserById(Integer id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @Override
    public ResponseEntity<User> getDemoUser() {
        log.info("getDemoUser Method started");
        User user = new User();
        Role role = new Role();
        List<Role> roles = new ArrayList<>();
        role.setName("admin");
        roles.add(role);

        user.setActive(true);
        user.setEmail("yadigar.alakbarli@gmail.com");
        user.setFirstName("Yadigar");
        user.setLastName("Elekberli");
        user.setImg(null);
        user.setMobile("050 420 23 18");
        user.setInfo("No Info");
        user.setState(true);
        user.setPassword(passwordEncoder.encode("yadigar"));
        user.setRoles(roles);
        log.info("getDemoUser Method finished");
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> addDemoUser(@Valid User user) {
        System.out.println(user);
        return ResponseEntity.ok(user);
    }


}
