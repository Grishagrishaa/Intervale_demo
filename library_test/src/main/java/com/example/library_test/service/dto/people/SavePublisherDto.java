package com.example.library_test.service.dto.people;


import javax.validation.constraints.Size;

public class SavePublisherDto  extends BasePeopleDto {
    @Size(min = 5, max = 15)
    private String country;

    public SavePublisherDto(String name, String country) {
        this.country = country;
    }

    public SavePublisherDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
