package com.example.exercise.services;

import com.example.exercise.domain.dtos.category.CategoryImportDTO;
import com.example.exercise.domain.dtos.product.ProductImportDTO;
import com.example.exercise.domain.dtos.user.UserImportDTO;
import com.example.exercise.domain.entities.Category;
import com.example.exercise.domain.entities.Product;
import com.example.exercise.domain.entities.User;
import com.example.exercise.repositories.CategoryRepository;
import com.example.exercise.repositories.ProductRepository;
import com.example.exercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.exercise.constants.Paths.*;
import static com.example.exercise.constants.Utils.GSON;
import static com.example.exercise.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() == 0) {
            FileReader fileReader = new FileReader(USER_PATH.toFile());

            List<User> users = Arrays.stream(GSON.fromJson(fileReader, UserImportDTO[].class)).
                    map(userDto -> MODEL_MAPPER.map(userDto, User.class)).
                    collect(Collectors.toList());

            this.userRepository.saveAllAndFlush(users);

            fileReader.close();
        }
    }

    @Override
    public void seedProducts() throws IOException {
        if (this.productRepository.count() == 0) {
            FileReader fileReader = new FileReader(PRODUCT_PATH.toFile());

            List<Product> products = Arrays.stream(GSON.fromJson(fileReader, ProductImportDTO[].class))
                    .map(productDTO -> MODEL_MAPPER.map(productDTO, Product.class))
                    .map(this::setRandomSeller)
                    .map(this::setRandomBuyer)
                    .map(this::setRandomCategories).collect(Collectors.toList());

            this.productRepository.saveAllAndFlush(products);

            fileReader.close();
        }

    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() == 0) {
            FileReader fileReader = new FileReader(CATEGORY_PATH.toFile());

            List<Category> categories = Arrays.stream(GSON.fromJson(fileReader, CategoryImportDTO[].class)).
                    map(categoryDTO -> MODEL_MAPPER.map(categoryDTO, Category.class)).
                    collect(Collectors.toList());

            this.categoryRepository.saveAllAndFlush(categories);

            fileReader.close();
        }
    }

    private Product setRandomCategories(Product product) {

        final Random random = new Random();

        int numberOfCategories = 0;
        if (this.categoryRepository.count() > 0) {
            numberOfCategories = random.nextInt((int) this.categoryRepository.count());
        }



        Set<Category> categories = new HashSet<>();

        IntStream.range(0, numberOfCategories).
                forEach(number -> {
                    Category category = this.categoryRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
                    categories.add(category);
                });

        product.setCategories(categories);


        return product;
    }

    private Product setRandomBuyer(Product product) {

        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
            User buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

            while (buyer.equals(product.getSeller())) {
                buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            }
            product.setBuyer(buyer);

        }
        return product;
    }


    private Product setRandomSeller(Product product) {
        User seller = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

        product.setSeller(seller);

        return product;
    }
}
