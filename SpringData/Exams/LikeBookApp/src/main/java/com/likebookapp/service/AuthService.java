package com.likebookapp.service;

import com.likebookapp.model.dtos.LoginDTO;
import com.likebookapp.model.dtos.RegisterDTO;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.session.LoggedUser;
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
        Optional<User> userOptional = this.userRepository.findByUsername(registerDTO.getUsername());

        if(userOptional.isPresent()){
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registerDTO.getEmail());

        if(byEmail.isPresent()) {
            return false;
        }

        if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
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

        Optional<User> optUser = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if(optUser.isEmpty()) {
            return false;
        }

        User user = optUser.get();

        this.loggedUser.login(user);

        return true;
    }
}
