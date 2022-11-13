package com.example.library_test.service.dto.people;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class BasePeopleDto {
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
