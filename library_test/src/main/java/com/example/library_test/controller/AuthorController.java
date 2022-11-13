package com.example.library_test.controller;

import com.example.library_test.dao.entity.Author;
import com.example.library_test.service.AuthorService;
import com.example.library_test.service.dto.people.SaveAuthorDto;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.author.path}")
public class AuthorController extends AbstractPeopleController<Author, SaveAuthorDto, AuthorService> {
    protected AuthorController(AuthorService service) {
        super(service, new TypeToken<Author>(){}.getType());
    }
}
