package com.backendlearning.restapi.controller;

import com.backendlearning.restapi.dto.ApiResponse;
import com.backendlearning.restapi.dto.UserRequest;
import com.backendlearning.restapi.dto.UserResponse;
import com.backendlearning.restapi.entity.User;
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
    public UserResponse createUser(@RequestBody UserRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@PathVariable Long id, @RequestBody UserRequest request){
        UserResponse users = userService.updateUser(id, request);

        ApiResponse<UserResponse> response = new ApiResponse<>(
                "User updated successfully",
                true,
                users
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        ApiResponse<Void> response = new ApiResponse<>(
                "User deleted successfully",
                true,
                null
                );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
