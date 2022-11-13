package com.example.library_test.controller.api;

import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.service.dto.books.BaseBookDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


public interface ICommonLibraryController<E extends BaseEntity, D extends BaseBookDto>{
     @PostMapping
     ResponseEntity<E> save( D dto);

     @GetMapping
     ResponseEntity<E> get(UUID uuid);

     @GetMapping
     ResponseEntity<Page<E>> getAll(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                    @RequestParam(required = false, defaultValue = "10", name = "size") Integer size);

     @GetMapping
     ResponseEntity<Page<E>> getByAuthor(String authorName, @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                         @RequestParam(required = false, defaultValue = "10", name = "size") Integer size);

     @GetMapping
     ResponseEntity<Page<E>> getByPublisher(String publisherName, @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                            @RequestParam(required = false, defaultValue = "10", name = "size") Integer size);

     @GetMapping
     ResponseEntity<Page<E>> getByYear(Integer year, @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                       @RequestParam(required = false, defaultValue = "10", name = "size") Integer size);

     @PutMapping
     ResponseEntity<E> update(UUID uuid, E entity);

     @DeleteMapping
     ResponseEntity delete(UUID uuid);
}
