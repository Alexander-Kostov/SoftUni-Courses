package com.example.exercise.services;

import com.example.exercise.domain.dtos.product.ProductInRangeWithNoBuyerDTO;
import com.example.exercise.domain.entities.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<ProductInRangeWithNoBuyerDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException;
}
