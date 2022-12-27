package com.example.crud.services;

import java.util.List;

import com.example.crud.models.UserModel;

public interface UserService {
    List<UserModel> getAllUser();
    UserModel getUserById(int userId);
    UserModel saveUser(UserModel userModel);
    void updateUser(int userId, UserModel user);
    void deleteUser(int userId, UserModel user);
}
