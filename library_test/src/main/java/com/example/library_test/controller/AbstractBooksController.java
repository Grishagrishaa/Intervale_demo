package com.example.library_test.controller;

import com.example.library_test.controller.api.ICommonLibraryController;
import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.service.api.ICommonBooksService;
import com.example.library_test.service.dto.books.BaseBookDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

public abstract class AbstractBooksController<E extends BaseEntity, D extends BaseBookDto, S extends ICommonBooksService<E>> implements ICommonLibraryController<E, D> {

    private final S service;
    private final Type typeToken;
    @Autowired
    private ModelMapper mapper;

    protected AbstractBooksController(S service, Type typeToken) {
        this.typeToken = typeToken;
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<E> save(@Valid @RequestBody D dto) {
        E entity = mapper.map(dto, typeToken);
        entity.setId(UUID.randomUUID());
        return new ResponseEntity<>(service.save(entity), CREATED);
    }

    @Override
    @GetMapping("/{uuid}")
    public ResponseEntity<E> get(@PathVariable UUID uuid) {
        return new ResponseEntity<>(service.get(uuid), OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<E>> getAll(@RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                          @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return new ResponseEntity<>(service.getAll(PageRequest.of(page, size)), OK);
    }

    @Override
    @GetMapping("/author/{authorName}")
    public ResponseEntity<Page<E>> getByAuthor(@PathVariable String authorName,
                                               @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                               @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return new ResponseEntity<>(service.getByAuthor(authorName, PageRequest.of(page, size)), OK);
    }

    @Override
    @GetMapping("/publisher/{publisherName}")
    public ResponseEntity<Page<E>> getByPublisher(@PathVariable String publisherName,
                                                  @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                                  @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return new ResponseEntity<>(service.getByPublisher(publisherName, PageRequest.of(page, size)), OK);
    }

    @Override
    @GetMapping("/year/{year}")
    public ResponseEntity<Page<E>> getByYear(@PathVariable Integer year,
                                             @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
                                             @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        return new ResponseEntity<>(service.getByYear(year, PageRequest.of(page, size)), OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<E> update(@PathVariable UUID id, @RequestBody E entity) {
        return new ResponseEntity<>(service.update(id, entity), OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(OK);
    }
}
