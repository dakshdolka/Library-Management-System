package com.example.LMS.Repository;

import com.example.LMS.Models.Book;
import com.example.LMS.Models.BookCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByName(String value);

    List<Book> findByAuth_Name(String value);

    List<Book> findByGenre(BookCategoryType bookCategoryType);
}
