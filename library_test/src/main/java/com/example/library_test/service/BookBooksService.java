package com.example.library_test.service;

import com.example.library_test.dao.books.IBookRepository;
import com.example.library_test.dao.entity.books.Book;
import org.springframework.stereotype.Service;

@Service
public class BookBooksService extends AbstractBooksService<Book, IBookRepository> {

    public BookBooksService(IBookRepository repository) {
        super(repository);
    }
}
