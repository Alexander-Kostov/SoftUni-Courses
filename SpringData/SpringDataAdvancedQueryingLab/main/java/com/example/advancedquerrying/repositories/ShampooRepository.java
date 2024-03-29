package com.example.advancedquerrying.repositories;

import com.example.advancedquerrying.entities.Shampoo;
import com.example.advancedquerrying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderByIdDesc(Size parsed);
    @Query("select s FROM Shampoo AS s " +
            "join s.ingredients as i " +
            "WHERE i.name = :ingredient")
    List<Shampoo> findByIngredient(String ingredient);
    @Query("SELECT s FROM Shampoo AS s " +
            "join s.ingredients AS i " +
            "WHERE i.name IN :ingredients")
    List<Shampoo> findByIngredients(List<String> ingredients);

    List<Shampoo> findBySizeOrLabelId(Size parsed, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    long countByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo AS s WHERE s.ingredients.size < :count")
    List<Shampoo> findByIngredientCountLessThan(int count);
}
