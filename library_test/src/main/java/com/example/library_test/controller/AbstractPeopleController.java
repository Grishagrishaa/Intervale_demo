package com.example.library_test.controller;

import com.example.library_test.controller.api.ICommonPeopleController;
import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.service.api.ICommonPeopleService;
import com.example.library_test.service.dto.books.BaseBookDto;
import com.example.library_test.service.dto.people.BasePeopleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public abstract class AbstractPeopleController<E extends BaseEntity, D extends BasePeopleDto, S extends ICommonPeopleService<E>> implements ICommonPeopleController<E, D> {

    private final S service;
    private final Type typeToken;
    @Autowired
    private ModelMapper mapper;

    protected AbstractPeopleController(S service, Type typeToken) {
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
