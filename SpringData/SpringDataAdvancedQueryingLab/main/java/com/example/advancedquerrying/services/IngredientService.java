package com.example.advancedquerrying.services;

import com.example.advancedquerrying.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectByName (String name);

    List<Ingredient> selectByName(List<String> names);

    void deleteByName(String name);

    void updatePrice();
}
