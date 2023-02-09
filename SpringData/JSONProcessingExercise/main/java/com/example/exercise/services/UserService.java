package com.example.exercise.services;

import com.example.exercise.domain.dtos.user.UsersWithSoldProductsDTO;
import com.example.exercise.domain.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<UsersWithSoldProductsDTO> findAllBySellingProductsBuyerIsNotNull() throws IOException;
}
