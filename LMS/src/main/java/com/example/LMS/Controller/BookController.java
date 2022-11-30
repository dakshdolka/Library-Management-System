package com.example.LMS.Controller;

import com.example.LMS.Models.Author;
import com.example.LMS.Models.Book;
import com.example.LMS.Models.BookCategoryType;
import com.example.LMS.Request.BookRequest;
import com.example.LMS.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bs;


    @PostMapping("/book")
    public void createbook(@Valid @RequestBody BookRequest bookrequest) {
        bs.insertbook(bookrequest);

    }

    @GetMapping("/find/all")
    public List<Book> findBooks(){

        return bs.fetchBooks();
    }


    @GetMapping("/find/search")
    public List<Book> findByCategory(@RequestParam("category") BookCategoryType bookCategoryType,
                                     @RequestParam("value") String value){

        return bs.fetchByCategory(bookCategoryType,value);
    }



}
