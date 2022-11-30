package com.example.LMS.Services;

import com.example.LMS.Models.Author;
import com.example.LMS.Models.Book;
import com.example.LMS.Models.BookCategoryType;
import com.example.LMS.Repository.AuthorRepository;
import com.example.LMS.Repository.BookRepository;
import com.example.LMS.Request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public void insertbook(BookRequest br){
        Book book=br.to();
        Author fromObject=br.getAuthor();
        Author authorFromDB =authorRepository.findByName(fromObject.getName());
        if(authorFromDB==null){
            authorFromDB=authorRepository.save(fromObject);
        }
        book.setAuth(authorFromDB);
        bookRepository.save(book);

    }
    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> fetchBooks() {
        return bookRepository.findAll();
    }

    public List<Book> fetchByCategory(BookCategoryType bookCategoryType,String value){

        switch(bookCategoryType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR:
                return bookRepository.findByAuth_Name(value);
            case GENRE:
                return bookRepository.findByGenre(BookCategoryType.valueOf(value));
            case BOOK_ID:
                return bookRepository.findAllById(Collections.singletonList(Integer.parseInt(value)));
            default:
                return new ArrayList<Book>();
        }
    }
    public List<Author> fetchauthor() {
        return authorRepository.findAll();
    }
}
