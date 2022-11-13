package com.example.library_test.service;

import com.example.library_test.dao.books.INewspaperBooksRepository;
import com.example.library_test.dao.entity.books.Newspaper;
import org.springframework.stereotype.Service;

@Service
public class NewspaperBooksService extends AbstractBooksService<Newspaper, INewspaperBooksRepository> {

    public NewspaperBooksService(INewspaperBooksRepository repository) {
        super(repository);
    }
}
