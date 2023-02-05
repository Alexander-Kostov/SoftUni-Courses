package com.example.exercise.services;

import com.example.exercise.entities.user.LoginDTO;
import com.example.exercise.entities.user.RegisterDTO;
import com.example.exercise.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User register(RegisterDTO registerDTO);

    Optional<User> login(LoginDTO loginData);

    void logout();

    User getLoggedUser();
}
