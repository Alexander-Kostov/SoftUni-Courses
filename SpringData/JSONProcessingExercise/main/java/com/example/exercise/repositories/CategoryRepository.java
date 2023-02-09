package com.example.exercise.repositories;

import com.example.exercise.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(value = "select * from `products_shop`.categories order by RAND() LIMIT 1", nativeQuery = true)
    Optional<Category> getRandomEntity();
}
