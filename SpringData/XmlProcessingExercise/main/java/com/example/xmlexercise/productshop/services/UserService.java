package com.example.xmlexercise.productshop.services;

import com.example.xmlexercise.productshop.entities.users.ExportSellersDTO;

public interface UserService {
    ExportSellersDTO findAllWithSoldProducts();
}
