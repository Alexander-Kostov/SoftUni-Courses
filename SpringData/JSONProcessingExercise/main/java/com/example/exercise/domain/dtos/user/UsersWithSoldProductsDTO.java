package com.example.exercise.domain.dtos.user;

import com.example.exercise.domain.dtos.product.ProductSoldDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersWithSoldProductsDTO {

    private String firstName;

    private String lastName;

    private List<ProductSoldDTO> boughtProducts;

}
