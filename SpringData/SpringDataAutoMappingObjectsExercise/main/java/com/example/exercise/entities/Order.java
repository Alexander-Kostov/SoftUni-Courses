package com.example.exercise.entities;

import com.example.exercise.entities.game.Game;
import com.example.exercise.entities.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User buyer;

    @ManyToMany
    private Set<Game> products;

    public Order() {}

    public Order(User buyer, Set<Game> products) {
        this.buyer = buyer;
        this.products = products;
    }
}
