package com.backendlearning.restapi.service;

import com.backendlearning.restapi.dto.UserRequest;
import com.backendlearning.restapi.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);
    List<UserResponse> getUsers();
}
