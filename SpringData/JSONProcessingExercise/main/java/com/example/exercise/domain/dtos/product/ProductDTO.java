package com.example.exercise.domain.dtos.product;

import com.example.exercise.domain.dtos.category.CategoryDTO;
import com.example.exercise.domain.dtos.user.UserDTO;
import com.example.exercise.domain.entities.Category;
import com.example.exercise.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;

    private BigDecimal price;


    private UserDTO seller;


    private UserDTO buyer;


    private Set<CategoryDTO> categories;

    public ProductInRangeWithNoBuyerDTO toProductInRangeWithNoBuyerDTO() {
        return new ProductInRangeWithNoBuyerDTO(name, price, seller.getFullName());
    }
}
