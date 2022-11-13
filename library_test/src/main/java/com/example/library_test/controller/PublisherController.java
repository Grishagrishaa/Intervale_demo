package com.example.library_test.controller;

import com.example.library_test.dao.entity.Publisher;
import com.example.library_test.service.PublisherService;
import com.example.library_test.service.dto.people.SavePublisherDto;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.publisher.path}")
public class PublisherController extends AbstractPeopleController<Publisher, SavePublisherDto, PublisherService> {
    protected PublisherController(PublisherService service) {
        super(service, new TypeToken<Publisher>(){}.getType());
    }
}
