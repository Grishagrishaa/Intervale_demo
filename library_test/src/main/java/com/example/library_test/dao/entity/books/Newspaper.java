package com.example.library_test.dao.entity.books;

import com.example.library_test.dao.entity.Author;
import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.dao.entity.Publisher;
import com.example.library_test.dao.entity.enums.EType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "newspapers", schema = "library")
public class Newspaper extends BaseEntity {
    private String title;
    private EType newsType;
    private Integer year;
//    @MappedCollection(idColumn = "id", keyColumn = "id")
    @ManyToMany(fetch = FetchType.EAGER)//for test
    @JoinTable(
            name = "newspapers_authors",
            joinColumns = @JoinColumn(name = "newspapers_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    @ManyToOne
    private Publisher publisher;

    public Newspaper(String title, EType newsType, Integer year, Set<Author> authors, Publisher publisher) {
        this.title = title;
        this.newsType = newsType;
        this.year = year;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Newspaper() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EType getNewsType() {
        return newsType;
    }

    public void setNewsType(EType newsType) {
        this.newsType = newsType;
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
