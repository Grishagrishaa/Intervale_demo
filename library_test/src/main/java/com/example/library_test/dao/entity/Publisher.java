package com.example.library_test.dao.entity;

//import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "publishers", schema = "library")
public class Publisher extends BaseEntity{
    private String name;
    private String country;

    public Publisher(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
