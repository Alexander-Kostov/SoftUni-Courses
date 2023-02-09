package com.example.exercise;

import com.example.exercise.services.ProductService;
import com.example.exercise.services.SeedService;
import com.example.exercise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {
    private SeedService seedService;
    private ProductService productService;
    private UserService userService;
    @Autowired
    public CommandRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAll();

//        this.productService.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(
//                BigDecimal.valueOf(500),
//                BigDecimal.valueOf(1000));
//
//        this.userService.findAllBySellingProductsBuyerIsNotNull();
    }
}
