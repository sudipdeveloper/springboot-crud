package com.example.crud.responses;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;

import com.example.crud.models.UserModel;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class UserResponse {
    private int status;
    private String message;
    private List<UserModel> data;


}
