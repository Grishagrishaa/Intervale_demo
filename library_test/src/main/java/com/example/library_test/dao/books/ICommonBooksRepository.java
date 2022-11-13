package com.example.library_test.dao.books;

import com.example.library_test.dao.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

@NoRepositoryBean
public interface ICommonBooksRepository<G extends BaseEntity> extends JpaRepository<G, UUID> {
    Page<G> findByAuthors_Name(String authorName, Pageable pageable);
    Page<G> findByYear(Integer year, Pageable pageable);
    Page<G> findByPublisher_Name(String publisherName, Pageable pageable);
}
