package com.edu.bhos.snap.userservice.controller;

import com.edu.bhos.snap.userservice.controller.abstracts.IUserController;
import com.edu.bhos.snap.userservice.entity.Role;
import com.edu.bhos.snap.userservice.entity.User;
import com.edu.bhos.snap.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/v1/user-service")
public class UserController implements IUserController {

    private static final Logger LOGGER = LogManager.getLogger("usercontroller");

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${message}")
    private String message;

    @Override
    public ResponseEntity<User> addUser(User _user) {
       User user=userService.addUser(_user);
       LOGGER.info("User add Succesfully");
        return ResponseEntity.ok(user);
    }
    @Override
    public ResponseEntity<User> findUserById(Integer id) {
        User user= userService.findUserById(id);
        LOGGER.info("Find User with id="+id);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<String> deleteUserById(Integer id) {
      userService.deleteUserById(id);
      LOGGER.info("Deleted User which id="+id);

      return ResponseEntity.ok("User Deleted Sucefully");
    }

    @Override
    public ResponseEntity<String> updatePhoto(MultipartFile img, HttpSession session) {
      Integer id= (Integer) session.getAttribute("user_id");
      boolean response=userService.updatePhoto(img,id);

        return response?ResponseEntity.ok("User photo update succesfully"):ResponseEntity.ok("Oops");
    }

    @Override
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Override
    public String index() {

            LOGGER.error("Xeta Bas verdi");

        return message;
    }


    @Override
    public ResponseEntity<User> getDemoUser() {
        LOGGER.info("getDemoUser Method started");
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
        LOGGER.error("getDemoUser Method finished");
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> addDemoUser(@Valid User user) {
        System.out.println(user);
        return ResponseEntity.ok(user);
    }


}
