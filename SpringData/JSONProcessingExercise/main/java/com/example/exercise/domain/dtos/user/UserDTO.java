package com.example.exercise.domain.dtos.user;

import com.example.exercise.domain.entities.Product;
import com.example.exercise.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    String firstName;

    String lastName;

    int age;

    Set<Product> sellingProducts;

    Set<Product> boughtProducts;

    Set<User> friends;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
