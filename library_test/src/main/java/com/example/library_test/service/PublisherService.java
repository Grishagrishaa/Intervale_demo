package com.example.library_test.service;

import com.example.library_test.dao.people.IPublisherPeopleRepository;
import com.example.library_test.dao.entity.Publisher;
import org.springframework.stereotype.Service;

@Service
public class PublisherService extends AbstractPeopleService<Publisher, IPublisherPeopleRepository> {

    public PublisherService(IPublisherPeopleRepository repository) {
        super(repository);
    }
}
