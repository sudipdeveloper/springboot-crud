package com.example.crud.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crud.models.UserModel;
import com.example.crud.responses.UserResponse;
import com.example.crud.services.UserService;
import requests.UserRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    protected UserService userService;
    @Autowired
     UserResponse userResponse;


    @GetMapping("/get/users")
    public UserResponse getAllUser() {
        List<UserModel> userList = new ArrayList<>();
        try {
            userList = userService.getAllUser();
            userResponse.setData(userList);
            userResponse.setMessage("Retrieved Successfully.");
            userResponse.setStatus(200);
        }catch (Exception e){
            userResponse.setData(userList);
            userResponse.setMessage(e.getMessage());
            userResponse.setStatus(500);
        }
        return userResponse;
    }

    @GetMapping("/get/user/{userId}")
    public UserResponse getUserById(@PathVariable int userId) {
       UserModel user = new UserModel();
        List<UserModel> userList = new ArrayList<>();
        try {
            user = userService.getUserById(userId);
            if(user != null){
                userList.add(user);
            }
            userResponse.setData(userList);
            userResponse.setMessage("Retrieved Successfully.");
            userResponse.setStatus(200);
        }catch (Exception e){
            userResponse.setData(userList);
            userResponse.setMessage(e.getMessage());
            userResponse.setStatus(500);
        }
        return userResponse;
    }

    @PostMapping("/add/user")
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        UserModel user = new UserModel();
        List<UserModel> userList = new ArrayList<>();
        try {
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPhone(userRequest.getPhone());
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            userService.saveUser(user);
            userList.add(user);
            userResponse.setData(userList);
            userResponse.setMessage("Data Inserted Successfully.");
            userResponse.setStatus(200);
        }catch (Exception e){
            userResponse.setData(userList);
            userResponse.setMessage(e.getMessage());
            userResponse.setStatus(500);
        }
        return userResponse;
    }

    @PostMapping("/update/user/{userId}")
    public UserResponse updateUser(@PathVariable int userId, @RequestBody UserRequest userRequest) {
        UserModel user = new UserModel();
        List<UserModel> userList = new ArrayList<>();
        try {
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPhone(userRequest.getPhone());
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            userService.updateUser(userId,user);
            user.setId(userId);
            userList.add(user);
            userResponse.setData(userList);
            userResponse.setMessage("Data Updated Successfully.");
            userResponse.setStatus(200);
        }catch (Exception e){
            userResponse.setData(userList);
            userResponse.setMessage(e.getMessage());
            userResponse.setStatus(500);
        }
        return userResponse;
    }

    @DeleteMapping("/delete/user/{userId}")
    public UserResponse deleteUser(@PathVariable int userId){
        List<UserModel> userList = new ArrayList<>();
        try{
            UserModel user = new UserModel();
            user.setIsDeleted(1);
            userService.deleteUser(userId,user);
            //userList.add(user);
            userResponse.setData(userList);
            userResponse.setMessage("Data Deleted Successfully.");
            userResponse.setStatus(200);
        }catch (Exception e){
            userResponse.setData(userList);
            userResponse.setMessage(e.getMessage());
            userResponse.setStatus(500);
        }
        return userResponse;
    }

}
