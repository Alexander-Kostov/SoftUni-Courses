package com.example.lab;

import com.example.lab.entities.dtos.AddressDTO;
import com.example.lab.entities.dtos.CreateEmployeeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class JasonTestMain implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().
                create();

        AddressDTO address1 = new AddressDTO("Bulgaria", "Sofia");
        AddressDTO address2 = new AddressDTO("Bulgaria", "Sofia");
        AddressDTO address3 = new AddressDTO("Bulgaria", "Sofia");

        CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO
                ("First", "Second", BigDecimal.TEN, LocalDate.now(), address1);


        List<AddressDTO> addressList = List.of(address1, address2, address3);

        System.out.println(gson.toJson(addressList));

        String json = gson.toJson(createEmployeeDTO);

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        AddressDTO[] addressDTOList = gson.fromJson(input, AddressDTO[].class);

//        System.out.println(gson.toJson(addressDTOList));

        System.out.println();
    }
}
