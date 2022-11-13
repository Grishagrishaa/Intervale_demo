package com.example.library_test.dao.books;

import com.example.library_test.dao.entity.books.Book;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends ICommonBooksRepository<Book> {

}
