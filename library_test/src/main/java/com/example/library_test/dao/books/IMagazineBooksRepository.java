package com.example.library_test.dao.books;

import com.example.library_test.dao.entity.books.Magazine;
import org.springframework.stereotype.Repository;

@Repository
public interface IMagazineBooksRepository extends ICommonBooksRepository<Magazine> {
}
