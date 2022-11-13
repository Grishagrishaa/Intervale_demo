package com.example.library_test.dao.people;

import com.example.library_test.dao.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

@NoRepositoryBean
public interface ICommonPeopleRepository<G extends BaseEntity> extends JpaRepository<G, UUID> {

}
