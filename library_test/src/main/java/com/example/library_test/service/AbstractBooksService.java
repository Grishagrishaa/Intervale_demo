package com.example.library_test.service;

import com.example.library_test.dao.books.ICommonBooksRepository;
import com.example.library_test.dao.entity.BaseEntity;
import com.example.library_test.service.api.ICommonBooksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public abstract class AbstractBooksService<E extends BaseEntity, R extends ICommonBooksRepository<E>> implements ICommonBooksService<E> {

    @Autowired
    private ModelMapper mapper;
//    @Autowired
    protected final R repository;

    protected AbstractBooksService(R repository) {
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
    @Cacheable(cacheNames="baseEntity")
    public Page<E> getByAuthor(String authorName, Pageable pageable) {
        return repository.findByAuthors_Name(authorName, pageable);
    }

    @Override
    @Cacheable(cacheNames="baseEntity")
    public Page<E> getByPublisher(String publisherName, Pageable pageable) {
        return repository.findByPublisher_Name(publisherName, pageable);
    }

    @Override
    @Cacheable(cacheNames="baseEntity")
    public Page<E> getByYear(Integer year, Pageable pageable) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {// TEST FOR CACHING
//            throw new RuntimeException(e);
//        }
        return repository.findByYear(year, pageable);
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
