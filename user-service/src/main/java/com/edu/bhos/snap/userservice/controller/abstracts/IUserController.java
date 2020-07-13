package com.edu.bhos.snap.userservice.controller.abstracts;

import com.edu.bhos.snap.userservice.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Api(value = "All User operation in this Controller")
public interface IUserController {

    @GetMapping("/index")
    String index();


    @ApiOperation(value = "This method responsible for user add operation")
    @PostMapping("/add")
    ResponseEntity<User> addUser(@Valid @RequestBody User user);

    @ApiOperation(value = "This method find user by user id")
    @GetMapping("/find/{id}")
    ResponseEntity<User> findUserById(@PathVariable Integer id);

    @ApiOperation(value = "This method  for user deleted by id")
    @GetMapping("/delete/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable Integer id);

    @ApiOperation(value = "For Adding user photo")
    @PostMapping("/addphoto")
    ResponseEntity<String> updatePhoto(@RequestParam("img") MultipartFile img, HttpSession session);

    @ApiOperation(value = "Get All User List")
    @GetMapping("getall")
    ResponseEntity<List<User>> getAll();

    @GetMapping("/getdemo")
    ResponseEntity<User> getDemoUser();

    @GetMapping("/addemo")
    ResponseEntity<User> addDemoUser(@Valid @RequestBody User user);

}
