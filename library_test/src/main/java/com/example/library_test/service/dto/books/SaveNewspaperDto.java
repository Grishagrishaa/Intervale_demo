package com.example.library_test.service.dto.books;

import com.example.library_test.dao.entity.Author;
import com.example.library_test.dao.entity.Publisher;
import com.example.library_test.dao.entity.enums.EType;

import java.util.List;

public class SaveNewspaperDto extends BaseBookDto {
    private EType newsType;
    private List<Author> authors;
    private Publisher publisher;

    public SaveNewspaperDto(String title, Integer year, List<Author> authors, Publisher publisher, EType newsType) {
        super(title, year);
        this.newsType = newsType;
        this.authors = authors;
        this.publisher = publisher;
    }

    public SaveNewspaperDto() {
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

    public EType getNewsType() {
        return newsType;
    }

    public void setNewsType(EType newsType) {
        this.newsType = newsType;
    }
}
