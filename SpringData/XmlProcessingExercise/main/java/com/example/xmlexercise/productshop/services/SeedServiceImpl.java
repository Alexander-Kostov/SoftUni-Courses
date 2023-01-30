package com.example.xmlexercise.productshop.services;

import com.example.xmlexercise.productshop.entities.categories.Category;
import com.example.xmlexercise.productshop.entities.categories.CategoriesImportDTO;
import com.example.xmlexercise.productshop.entities.products.Product;
import com.example.xmlexercise.productshop.entities.products.ProductsImportDTO;
import com.example.xmlexercise.productshop.entities.users.User;
import com.example.xmlexercise.productshop.entities.users.UsersImportDTO;
import com.example.xmlexercise.productshop.repositories.CategoryRepository;
import com.example.xmlexercise.productshop.repositories.ProductRepository;
import com.example.xmlexercise.productshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private static final Path USER_PATH = Path.of("src\\main\\resources\\productshop\\users.xml");

    private static final Path CATEGORY_PATH = Path.of("src\\main\\resources\\productshop\\categories.xml");

    private static final Path PRODUCT_PATH = Path.of("src\\main\\resources\\productshop\\products.xml");

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public SeedServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;

        this.modelMapper = new ModelMapper();
    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(UsersImportDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BufferedReader xmlReader = Files.newBufferedReader(USER_PATH);

        UsersImportDTO usersDTOs = (UsersImportDTO) unmarshaller.unmarshal(xmlReader);

        List<User> entities = usersDTOs.getUsers().stream().map(dto -> modelMapper.map(dto, User.class)).collect(Collectors.toList());

        this.userRepository.saveAll(entities);

    }

    @Override
    public void seedCategories() throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(CategoriesImportDTO.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        FileReader xmlReader = new FileReader(CATEGORY_PATH.toAbsolutePath().toString());
        CategoriesImportDTO importDTO = (CategoriesImportDTO) unmarshaller.unmarshal(xmlReader);

        List<Category> entities = importDTO.getCategories().stream().map(cn -> new Category(cn.getName())).collect(Collectors.toList());

        this.categoryRepository.saveAll(entities);
    }

    @Override
    public void seedProducts() throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(ProductsImportDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BufferedReader bufferedReader = Files.newBufferedReader(PRODUCT_PATH);
        ProductsImportDTO importDTOs = (ProductsImportDTO) unmarshaller.unmarshal(bufferedReader);

        List<Product> entities = importDTOs.getProducts().stream().map(dto -> new Product(dto.getName(), dto.getPrice()))
                .map(this::setRandomCategories)
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .collect(Collectors.toList());

        this.productRepository.saveAll(entities);
    }

    @Override
    public void seedAll() throws IOException, JAXBException {
        SeedService.super.seedAll();
    }

    private Product setRandomCategories(Product product) {
        Random random = new Random();
        long categoriesDbCount = this.categoryRepository.count();

        int count = random.nextInt((int) categoriesDbCount);

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int randomId = random.nextInt((int) categoriesDbCount) + 1;

            Optional<Category> randomCategory = this.categoryRepository.findById(randomId);

            categories.add(randomCategory.get());
        }

        product.setCategories(categories);
        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(944)) > 0) {
            return product;
        }

        Optional<User> buyer = getRandomUser();

        product.setBuyer(buyer.get());

        return product;
    }

    private Product setRandomSeller(Product product) {
        Optional<User> seller = getRandomUser();

        product.setSeller(seller.get());

        return product;
    }

    private Optional<User> getRandomUser() {
        long usersCount = this.userRepository.count();

        // 0..4 + 1 = 1..5
        int randomUserId = new Random().nextInt((int) usersCount) + 1;

        return this.userRepository.findById(randomUserId);
    }
}
