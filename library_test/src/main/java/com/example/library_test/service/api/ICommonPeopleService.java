package com.example.library_test.service.api;

import com.example.library_test.dao.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ICommonPeopleService<E extends BaseEntity>{
    E save(E entity);

    E get(UUID uuid);

    Page<E> getAll(Pageable pageable);

    E update(UUID uuid, E entity);

    void delete(UUID uuid);
}
