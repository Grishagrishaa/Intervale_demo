package com.example.library_test.service.dto.books;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public abstract class BaseBookDto {
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 35)
    private String title;
    @NotNull
    private Integer year;


    public BaseBookDto(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public BaseBookDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


}
