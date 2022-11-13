package com.example.library_test.controller;

import com.example.library_test.dao.entity.books.Book;
import com.example.library_test.dao.entity.books.Magazine;
import com.example.library_test.service.MagazineBooksService;
import com.example.library_test.service.dto.books.SaveMagazineDto;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.magazine.path}")
public class MagazineController extends AbstractBooksController<Magazine, SaveMagazineDto, MagazineBooksService> {
    protected MagazineController(MagazineBooksService service) {
        super(service, new TypeToken<Magazine>(){}.getType());
    }
}
