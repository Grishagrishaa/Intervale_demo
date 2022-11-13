package com.example.library_test.controller;

import com.example.library_test.dao.entity.books.Book;
import com.example.library_test.service.BookBooksService;
import com.example.library_test.service.dto.books.SaveBookDto;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.book.path}")
public class BookController extends AbstractBooksController<Book, SaveBookDto, BookBooksService> {
    protected BookController(BookBooksService service) {
        super(service, new TypeToken<Book>(){}.getType());
    }
}
