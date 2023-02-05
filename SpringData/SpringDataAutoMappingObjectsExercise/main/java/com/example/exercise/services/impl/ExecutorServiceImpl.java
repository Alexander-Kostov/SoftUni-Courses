package com.example.exercise.services.impl;

import com.example.exercise.entities.user.LoginDTO;
import com.example.exercise.entities.user.RegisterDTO;
import com.example.exercise.entities.user.User;
import com.example.exercise.services.ExecutorService;
import com.example.exercise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExecutorServiceImpl implements ExecutorService {

    private final UserService userService;

    @Autowired
    public ExecutorServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(String command) {
        String[] commandParts = command.split("\\|");

        String commandName = commandParts[0];

        String commandInput = switch (commandName) {
            case REGISTER_USER_COMMAND -> registerUser(commandParts);
            case LOGIN_USER_COMMAND -> loginUser(commandParts);
            case LOGOUT_USER_COMMAND -> logoutUser();
            case ADD_GAME_COMMAND -> addGame();
            default -> "unknown command";
        };

        return commandInput;
    }

    private String addGame() {
        User loggedUser = this.userService.getLoggedUser();


        //TODO
        return String.format("GameInfo");
    }

    private String logoutUser() {
        User loggedUser = this.userService.getLoggedUser();
        this.userService.logout();
        return String.format("User %s successfully logged out.", loggedUser.getFullName());
    }

    private String loginUser(String[] commandParts) {
        LoginDTO loginData = new LoginDTO(commandParts);

        Optional<User> user = userService.login(loginData);

        if (user.isPresent()) {
            return String.format("Successfully logged in %s", user.get().getFullName());
        }else {
            return "Wrong Credentials";
        }
    }

    private String registerUser(String[] commandParts) {
        RegisterDTO registerData = new RegisterDTO(commandParts);
        User user = userService.register(registerData);

        return String.format("%s was registered", user.getFullName());
    }
}

