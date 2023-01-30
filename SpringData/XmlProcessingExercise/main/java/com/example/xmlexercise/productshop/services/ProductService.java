package com.example.xmlexercise.productshop.services;

import com.example.xmlexercise.productshop.entities.products.ExportProductsInRangeDTO;

public interface ProductService {
    ExportProductsInRangeDTO getInRange(float from, float to);
}
