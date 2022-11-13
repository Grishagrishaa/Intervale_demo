package com.example.library_test.service.dto.books;

import com.example.library_test.dao.entity.Author;
import com.example.library_test.dao.entity.Publisher;

import javax.validation.constraints.Size;
import java.util.List;

public class SaveMagazineDto extends BaseBookDto {
    @Size(min = 5, max = 35)
    private String topic;
    private List<Author> authors;
    private Publisher publisher;

    public SaveMagazineDto(String title, Integer year, List<Author> authors, Publisher publisher, String topic) {
        super(title, year);
        this.topic = topic;
        this.authors = authors;
        this.publisher = publisher;
    }

    public SaveMagazineDto() {
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
