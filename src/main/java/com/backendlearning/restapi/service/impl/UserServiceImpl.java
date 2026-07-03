package com.backendlearning.restapi.service.impl;

import com.backendlearning.restapi.dto.UserRequest;
import com.backendlearning.restapi.dto.UserResponse;
import com.backendlearning.restapi.entity.User;
import com.backendlearning.restapi.repository.UserRepository;
import com.backendlearning.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request){
        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setUsername(savedUser.getUsername());

        return userResponse;
    }

    @Override
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();

        for(User user : users){
            UserResponse userResponse = new UserResponse();

            userResponse.setId(user.getId());
            userResponse.setEmail(user.getEmail());
            userResponse.setUsername(user.getUsername());

            userResponseList.add(userResponse);
        }
        return userResponseList;
    }
}
