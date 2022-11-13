package com.example.library_test.controller;

import com.example.library_test.dao.entity.books.Book;
import com.example.library_test.dao.entity.books.Newspaper;
import com.example.library_test.service.NewspaperBooksService;
import com.example.library_test.service.dto.books.SaveNewspaperDto;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.newspaper.path}")
public class NewspaperController extends AbstractBooksController<Newspaper, SaveNewspaperDto, NewspaperBooksService> {
    protected NewspaperController(NewspaperBooksService service) {
        super(service, new TypeToken<Newspaper>(){}.getType());
    }
}
