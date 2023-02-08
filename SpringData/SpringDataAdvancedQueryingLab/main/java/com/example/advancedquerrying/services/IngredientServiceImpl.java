package com.example.advancedquerrying.services;

import com.example.advancedquerrying.entities.Ingredient;
import com.example.advancedquerrying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectByName(String name) {
        return this.ingredientRepository.findByNameStartsWith(name);
    }

    @Override
    public List<Ingredient> selectByName(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPrice(names);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        this.ingredientRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void updatePrice(){
        this.ingredientRepository.updateAllPrice();
    }
}
