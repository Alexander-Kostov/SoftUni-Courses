package com.example.xmlexercise.productshop.services;

import com.example.xmlexercise.productshop.entities.products.Product;
import com.example.xmlexercise.productshop.entities.products.ExportProductsInRangeDTO;
import com.example.xmlexercise.productshop.entities.products.ProductWithAttributesDTO;
import com.example.xmlexercise.productshop.entities.users.User;
import com.example.xmlexercise.productshop.repositories.ProductRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    private final TypeMap<Product, ProductWithAttributesDTO> productToDTOMapping;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.mapper = new ModelMapper();

        Converter<User, String> userToNameConverter = context -> context.getSource() == null ? null : context.getSource().getFullName();

        TypeMap<Product, ProductWithAttributesDTO> typeMap =
                this.mapper.createTypeMap(Product.class, ProductWithAttributesDTO.class);

        productToDTOMapping = typeMap.addMappings(map -> map.using(userToNameConverter).map(Product::getSeller, ProductWithAttributesDTO::setSeller));


    }

    @Override
    public ExportProductsInRangeDTO getInRange(float from, float to) {
        BigDecimal rangeFrom = BigDecimal.valueOf(from);
        BigDecimal rangeTo = BigDecimal.valueOf(to);

        List<Product> products = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(rangeFrom, rangeTo);

        List<ProductWithAttributesDTO> dtos = products.stream()
                .map(this.productToDTOMapping::map)
                .collect(Collectors.toList());

        return new ExportProductsInRangeDTO(dtos);
    }
}
