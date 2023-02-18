package com.example.demo;

import com.example.demo.model.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class ShoppingList {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingList.class, args);

        HashSet<User> collection = new HashSet<>();
    }

}
