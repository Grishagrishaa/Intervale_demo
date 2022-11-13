package com.example.library_test.service;

import com.example.library_test.dao.books.IMagazineBooksRepository;
import com.example.library_test.dao.entity.books.Magazine;
import org.springframework.stereotype.Service;

@Service
public class MagazineBooksService extends AbstractBooksService<Magazine, IMagazineBooksRepository> {

    public MagazineBooksService(IMagazineBooksRepository repository) {
        super(repository);
    }
}
