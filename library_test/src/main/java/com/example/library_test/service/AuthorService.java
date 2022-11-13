package com.example.library_test.service;

import com.example.library_test.dao.people.IAuthorPeopleRepository;
import com.example.library_test.dao.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends AbstractPeopleService<Author, IAuthorPeopleRepository> {

    public AuthorService(IAuthorPeopleRepository repository) {
        super(repository);
    }
}
