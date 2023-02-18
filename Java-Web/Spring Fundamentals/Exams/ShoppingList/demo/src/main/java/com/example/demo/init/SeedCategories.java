package com.example.demo.init;

import com.example.demo.model.entity.Category;
import com.example.demo.model.enums.CategoryName;
import com.example.demo.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedCategories implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    public SeedCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() <= 0) {

            List<Category> categories = Arrays.stream(CategoryName.values()).map(Category::new).collect(Collectors.toList());
            this.categoryRepository.saveAll(categories);

        }
    }
}
