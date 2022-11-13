package com.example.library_test.service;

import com.example.library_test.dao.books.ICommonBooksRepository;
import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.dao.people.ICommonPeopleRepository;
import com.example.library_test.service.api.ICommonBooksService;
import com.example.library_test.service.api.ICommonPeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public abstract class AbstractPeopleService<E extends BaseEntity, R extends ICommonPeopleRepository<E>> implements ICommonPeopleService<E> {

    @Autowired
    private ModelMapper mapper;
//    @Autowired
    protected final R repository;

    protected AbstractPeopleService(R repository) {
        this.repository = repository;
    }


    @Override
    @CachePut(cacheNames="baseEntity")
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Cacheable(cacheNames="baseEntity")
    public E get(UUID uuid) {
        return repository.findById(uuid).orElseThrow( () -> new IllegalArgumentException("NOT FOUND"));
    }

    @Override
    public Page<E> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    @CachePut(cacheNames="baseEntity")
    public E update(UUID uuid, E entity) {
        E dbEntity = get(uuid);

        mapper.map(entity, dbEntity);//source -> destination

        return repository.save(dbEntity);
    }

    @Override
    @CacheEvict(cacheNames = "baseEntity")
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

}
