package com.example.exercise.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    int age;

    @OneToMany(targetEntity = Product.class, mappedBy = "seller")
    @Fetch(FetchMode.JOIN)
    Set<Product> sold;

    @OneToMany(targetEntity = Product.class, mappedBy = "buyer")
    @Fetch(FetchMode.JOIN)
    Set<Product> bought;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    Set<User> friends;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, getId());
    }
}
