package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.models.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer>
{
    List<UserModel> findAll();
    UserModel findByIdAndIsDeleted(int id, int isDeleted);
}
