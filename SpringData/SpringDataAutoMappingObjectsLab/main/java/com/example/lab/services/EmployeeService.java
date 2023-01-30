package com.example.lab.services;

import com.example.lab.entities.Employee;
import com.example.lab.entities.dtos.CreateEmployeeDTO;
import com.example.lab.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();
}
