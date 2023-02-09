package com.example.exercise.services;

import com.example.exercise.constants.Paths;
import com.example.exercise.domain.dtos.product.ProductDTO;
import com.example.exercise.domain.dtos.product.ProductInRangeWithNoBuyerDTO;
import com.example.exercise.domain.entities.Product;
import com.example.exercise.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.exercise.constants.Utils.MODEL_MAPPER;
import static com.example.exercise.constants.Utils.writeJsonIntoFile;


public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductInRangeWithNoBuyerDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException {
        List<ProductInRangeWithNoBuyerDTO> products = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low, high)
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(product -> MODEL_MAPPER.map(product, ProductDTO.class))
                .map(ProductDTO::toProductInRangeWithNoBuyerDTO).collect(Collectors.toList());

        writeJsonIntoFile(products, Paths.PRODUCTS_WITH_NO_BUYERS_IN_RANGE);
        return products;
    }
}
