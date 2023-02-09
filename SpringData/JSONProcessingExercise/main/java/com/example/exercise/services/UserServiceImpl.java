package com.example.exercise.services;

import com.example.exercise.constants.Paths;
import com.example.exercise.domain.dtos.user.UsersWithSoldProductsDTO;
import com.example.exercise.domain.entities.User;
import com.example.exercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.exercise.constants.Utils.MODEL_MAPPER;
import static com.example.exercise.constants.Utils.writeJsonIntoFile;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UsersWithSoldProductsDTO> findAllBySellingProductsBuyerIsNotNull() throws IOException {
        List<UsersWithSoldProductsDTO> users = this.userRepository.findAllBySellingProductsBuyerIsNotNull()
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UsersWithSoldProductsDTO.class)).collect(Collectors.toList());

        writeJsonIntoFile(users, Paths.USERS_WITH_SOLD_PRODUCTS);
        return users;
    }
}
