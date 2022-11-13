package com.example.library_test.service.dto.books;

import com.example.library_test.dao.entity.Author;
import com.example.library_test.dao.entity.Publisher;

import java.util.List;

public class SaveBookDto extends BaseBookDto {
    private List<Author> authors;
    private Publisher publisher;

    public SaveBookDto(String title, Integer year, List<Author> authors, Publisher publisher) {
        super(title, year);
        this.authors = authors;
        this.publisher = publisher;
    }


    public SaveBookDto() {
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
