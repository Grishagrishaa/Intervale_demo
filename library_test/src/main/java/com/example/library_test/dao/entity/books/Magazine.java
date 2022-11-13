package com.example.library_test.dao.entity.books;

import com.example.library_test.dao.entity.Author;
import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.dao.entity.Publisher;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "magazines", schema = "library")
public class Magazine extends BaseEntity {
    private String title;
    private String topic;
    private Integer year;
//    @MappedCollection(idColumn = "id", keyColumn = "id")
    @ManyToMany(fetch = FetchType.EAGER)//for test
    @JoinTable(
            name = "magazines_authors",
            joinColumns = @JoinColumn(name = "magazines_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    @ManyToOne
    private Publisher publisher;

    public Magazine(String title, String topic, Integer year, Set<Author> authors, Publisher publisher) {
        this.title = title;
        this.topic = topic;
        this.year = year;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Magazine() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
