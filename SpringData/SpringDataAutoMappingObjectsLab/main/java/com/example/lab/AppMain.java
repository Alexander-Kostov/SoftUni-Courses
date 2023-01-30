package com.example.lab;

import com.example.lab.entities.Address;
import com.example.lab.entities.Employee;
import com.example.lab.entities.dtos.AddressDTO;
import com.example.lab.entities.dtos.CreateEmployeeDTO;
import com.example.lab.services.EmployeeService;
import com.example.lab.services.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class AppMain implements CommandLineRunner {

    private addressService addressService;
    private EmployeeService employeeService;

    @Autowired
    public AppMain(com.example.lab.services.addressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

//        createAddress(scanner);
//        createEmployee(scanner);
//        printAllEmployees();
    }

    private void createEmployee(Scanner scanner) {
        String firstName = scanner.nextLine();
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        LocalDate birthday = LocalDate.parse(scanner.nextLine());

        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);

        Employee employee = this.employeeService.create(employeeDTO);
        System.out.println(employee);
    }

    private void printAllEmployees(){
        this.employeeService.findAll().forEach(System.out::println);
    }

    private void createAddress(Scanner scanner) {
        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO data = new AddressDTO(country, city);
        Address address = addressService.create(data);

        System.out.println(address);
    }
}
