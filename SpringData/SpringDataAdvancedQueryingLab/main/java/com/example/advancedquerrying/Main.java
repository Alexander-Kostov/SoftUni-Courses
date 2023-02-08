package com.example.advancedquerrying;

import com.example.advancedquerrying.entities.Ingredient;
import com.example.advancedquerrying.entities.Shampoo;
import com.example.advancedquerrying.services.IngredientService;
import com.example.advancedquerrying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private ShampooService shampooService;

    private IngredientService ingredientService;

    @Autowired
    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);


//        String name = scanner.nextLine();
//        long labelId = Long.parseLong(scanner.nextLine());

//        List<String> ingredients = new ArrayList<>();
//        while (!nextLine.isBlank()){
//            ingredients.add(nextLine);
//
//            nextLine = scanner.nextLine();
//        }
//        for (Shampoo shampoo : this.shampooService.findByIngredientCountLessThan(count)) {
//            System.out.println(shampoo);
//        }

//        for (Ingredient ingredient : this.ingredientService.selectByName(ingredients)) {
//            System.out.println(ingredient);
//        }

//        System.out.println(this.shampooService.countWithPriceLowerThan(price));

        this.ingredientService.updatePrice();
    }
}
