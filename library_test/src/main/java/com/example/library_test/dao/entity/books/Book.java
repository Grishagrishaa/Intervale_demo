package com.example.library_test.dao.entity.books;

import com.example.library_test.dao.entity.Author;
import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.dao.entity.Publisher;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.MappedCollection;
//import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books", schema = "library")
public class Book extends BaseEntity {
    private String title;
    @Column(name = "issue_year")
    private Integer year;
//    @MappedCollection(idColumn = "id")
    @ManyToMany(fetch = FetchType.EAGER)//for test
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    @ManyToOne
    private Publisher publisher;

    public Book(String title, Integer year, Set<Author> authors, Publisher publisher) {
        this.title = title;
        this.year = year;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Book() {
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
