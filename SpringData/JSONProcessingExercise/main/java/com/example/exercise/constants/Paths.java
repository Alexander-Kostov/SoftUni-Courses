package com.example.exercise.constants;

import java.nio.file.Path;

public class Paths {
    ;

    public static final Path USER_PATH = Path.of("src\\main\\resources\\dbContent\\users.json");
    public static final Path CATEGORY_PATH = Path.of("src\\main\\resources\\dbContent\\categories.json");

    public static final Path PRODUCT_PATH = Path.of("src\\main\\resources\\dbContent\\products.json");

    public static final Path PRODUCTS_WITH_NO_BUYERS_IN_RANGE = Path.of("src\\main\\resources\\outputs\\products-in-range.json");

    public static final Path USERS_WITH_SOLD_PRODUCTS = Path.of("src\\main\\resources\\outputs\\users-sold-products.json");
}
