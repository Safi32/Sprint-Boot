package com.backendlearning.restapi.controller;

import com.backendlearning.restapi.dto.UserRequest;
import com.backendlearning.restapi.dto.UserResponse;
import com.backendlearning.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse registerUser(@RequestBody UserRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }
}
