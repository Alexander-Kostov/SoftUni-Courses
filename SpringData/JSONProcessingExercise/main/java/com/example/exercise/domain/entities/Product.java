package com.example.exercise.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{

    
    private String name;

    private BigDecimal price;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private User seller;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private User buyer;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Category> categories;
}
