package com.example.lab.services;

import com.example.lab.entities.Address;
import com.example.lab.entities.Employee;
import com.example.lab.entities.dtos.CreateEmployeeDTO;
import com.example.lab.entities.dtos.EmployeeDTO;
import com.example.lab.repositories.AddressRepository;
import com.example.lab.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;

    public EmployeeServiceImpl(AddressRepository addressRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
        this.mapper = modelMapper;
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO employeeDTO) {

        Employee employee = mapper.map(employeeDTO, Employee.class);

        Optional<Address> address = this.addressRepository.findByCountryAndCity(employee.getAddress().getCountry(),
                employee.getAddress().getCity());

        address.ifPresent(employee::setAddress);


        return this.employeeRepository.save(employee);

    }

    @Override
    public List<EmployeeDTO> findAll() {
        ModelMapper mapper = new ModelMapper();

        return this.employeeRepository.findAll().stream().
                map(e -> mapper.map(e,EmployeeDTO.class)).
                collect(Collectors.toList());
    }
}
