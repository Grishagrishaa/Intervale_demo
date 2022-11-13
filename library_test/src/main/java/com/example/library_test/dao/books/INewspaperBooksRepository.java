package com.example.library_test.dao.books;

import com.example.library_test.dao.entity.books.Newspaper;
import org.springframework.stereotype.Repository;

@Repository
public interface INewspaperBooksRepository extends ICommonBooksRepository<Newspaper> {
}
