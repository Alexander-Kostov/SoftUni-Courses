package com.example.exercise.domain.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInRangeWithNoBuyerDTO {

    private String name;

    private BigDecimal price;

    private String seller;
}
