package com.example.exercise.services.impl;

import com.example.exercise.entities.user.LoginDTO;
import com.example.exercise.entities.user.RegisterDTO;
import com.example.exercise.entities.user.User;
import com.example.exercise.exceptions.UserNotLoggedInException;
import com.example.exercise.repositories.UserRepository;
import com.example.exercise.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private User currentUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.currentUser = null;
    }

    @Override
    public User register(RegisterDTO registerData) {
        if (this.currentUser != null) {

        }
        ModelMapper mapper = new ModelMapper();
        User toRegister = mapper.map(registerData, User.class);

        long userCount = this.userRepository.count();

        if (userCount == 0) {
            toRegister.setAdmin(true);
        }
        return this.userRepository.save(toRegister);
    }

    @Override
    public Optional<User> login(LoginDTO loginData) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(loginData.getEmail(), loginData.getPassword());

        user.ifPresent(value -> this.currentUser = value);
        return user;

    }

    public User getLoggedUser() {
        if (this.currentUser == null) {
            throw new UserNotLoggedInException();
        }
        return this.currentUser;
    }

    @Override
    public void logout() {
        this.currentUser = null;
    }
}
