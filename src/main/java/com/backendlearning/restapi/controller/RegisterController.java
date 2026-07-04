package com.backendlearning.restapi.controller;

import com.backendlearning.restapi.dto.ApiResponse;
import com.backendlearning.restapi.dto.UserRequest;
import com.backendlearning.restapi.dto.UserResponse;
import com.backendlearning.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest request){
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        ApiResponse response = new ApiResponse("User deleted successfully", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }
}
