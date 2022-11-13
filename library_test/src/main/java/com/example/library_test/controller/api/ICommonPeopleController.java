package com.example.library_test.controller.api;

import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.service.dto.books.BaseBookDto;
import com.example.library_test.service.dto.people.BasePeopleDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


public interface ICommonPeopleController<E extends BaseEntity, D extends BasePeopleDto>{
     @PostMapping
     ResponseEntity<E> save( D dto);

     @GetMapping
     ResponseEntity<E> get(UUID uuid);

     @GetMapping
     ResponseEntity<Page<E>> getAll(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                    @RequestParam(required = false, defaultValue = "10", name = "size") Integer size);

     @PutMapping
     ResponseEntity<E> update(UUID uuid, E entity);

     @DeleteMapping
     ResponseEntity delete(UUID uuid);
}
