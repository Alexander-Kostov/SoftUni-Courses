package com.example.lab.services;

import com.example.lab.entities.Address;
import com.example.lab.entities.dtos.AddressDTO;
import com.example.lab.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addressServiceImpl implements addressService {
    private AddressRepository addressRepository;

    @Autowired
    public addressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(AddressDTO data) {
        ModelMapper modelMapper = new ModelMapper();

        Address address = modelMapper.map(data, Address.class);


        return this.addressRepository.save(address);
    }
}
