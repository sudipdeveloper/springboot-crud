package com.example.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.models.UserModel;
import com.example.crud.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserModel> getAllUser() {
      List<UserModel> userList;
        userList = userRepository.findAll();
        return userList;
    }

    @Override
    public UserModel getUserById(int userId) {
        UserModel user = new UserModel();
        user = userRepository.findByIdAndIsDeleted(userId,0);
        return user;
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        UserModel user = new UserModel();
        user = userRepository.save(userModel);
        return user;
    }

    @Override
    public void updateUser(int userId, UserModel user) {
        UserModel userEntity = userRepository.findByIdAndIsDeleted(userId,0);
        userEntity.setName(user.getName());
        userEntity.setUserName(user.getUserName());
        userEntity.setPhone(user.getPhone());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(int userId, UserModel user) {
        UserModel userEntity = userRepository.findByIdAndIsDeleted(userId,0);
        userEntity.setIsDeleted(user.getIsDeleted());
        userRepository.save(userEntity);
    }

}
