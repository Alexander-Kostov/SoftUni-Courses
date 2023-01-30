package com.example.lab.services;

import com.example.lab.entities.Address;
import com.example.lab.entities.dtos.AddressDTO;

public interface addressService {
    Address create(AddressDTO data);
}
