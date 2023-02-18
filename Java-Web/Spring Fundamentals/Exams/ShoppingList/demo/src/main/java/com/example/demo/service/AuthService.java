package com.example.demo.service;

import com.example.demo.model.dto.LoginDTO;
import com.example.demo.model.dto.RegisterDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private LoggedUser loggedUser;

    public AuthService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public boolean register(RegisterDTO registerDTO) {

        Optional<User> byEmail = this.userRepository.findByEmail(registerDTO.getEmail());

        if(byEmail.isPresent()) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registerDTO.getUsername());

        if(byUsername.isPresent()) {
            return false;
        }

        if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());

        this.userRepository.save(user);

        return true;

    }

    public boolean login(LoginDTO loginDTO) {

        Optional<User> byUsernameAndPassword = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if(byUsernameAndPassword.isEmpty()) {
            return false;
        }

        User user = byUsernameAndPassword.get();

        this.loggedUser.login(user);

        return true;
    }
}
