package com.example.library_test.dao.people;

import com.example.library_test.dao.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorPeopleRepository extends ICommonPeopleRepository<Author> {
}
