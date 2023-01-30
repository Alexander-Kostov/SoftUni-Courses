package com.example.lab.entities.dtos;

import com.google.gson.annotations.Expose;

public class AddressDTO  {
    @Expose
    private String country;
    @Expose
    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
