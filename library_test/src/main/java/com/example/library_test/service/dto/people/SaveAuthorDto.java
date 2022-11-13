package com.example.library_test.service.dto.people;

import com.example.library_test.service.dto.books.BaseBookDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class SaveAuthorDto extends BasePeopleDto {

    @Size(min = 5, max = 15)
    private String lastname;
    @NotNull
    private Integer birthYear;

    public SaveAuthorDto(String name, String lastname, Integer birthYear) {
        this.lastname = lastname;
        this.birthYear = birthYear;
    }

    public SaveAuthorDto() {
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
}
