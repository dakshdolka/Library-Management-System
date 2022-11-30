package com.example.LMS.Services;


import com.example.LMS.Models.*;
import com.example.LMS.RecordNotFoundException;
import com.example.LMS.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {


    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;
    public String issueBook(int studentId,int bookId) throws RecordNotFoundException {

        Student student=studentService.findStudent(studentId);
        if(student==null){
            throw new RecordNotFoundException("student is not present corresponding to this student id");
        }

List<Book> books=bookService.fetchByCategory(BookCategoryType.BOOK_ID,String.valueOf(bookId));
        if(books==null || books.size()!=1){
            throw new RecordNotFoundException("Book id is not present");
        }
        if(books.get(0).getStudent()!=null){
            throw new RecordNotFoundException("Book is already assigned to someone else");
        }


        Transaction transaction=Transaction.builder().payment(0)
                        .transactionType(TransactionType.ISSUE)
                        .transactionId(UUID.randomUUID().toString()).
                    book(books.get(0)).st(student).build();
        transactionRepository.save(transaction);
        books.get(0).setStudent(student);
        bookService.updateBook(books.get(0));
        return transaction.getTransactionId();
    }


    public String returnBook(int sid, int bookId) throws RecordNotFoundException {

        Student st=studentService.findStudent(sid);
        if(st==null){
            throw new RecordNotFoundException("Student is not present with id:"+sid);
        }

        List<Book> book=bookService.fetchByCategory(BookCategoryType.BOOK_ID,String.valueOf(bookId));
        if(book==null || book.size()!=1){
            throw new RecordNotFoundException("Book is not present with book id:"+bookId);
        }

        if(book.get(0).getStudent().getId()!=sid){
            throw new RecordNotFoundException("Book is not issued to thi student");
        }

        Transaction IssueTransaction=transactionRepository.findTopByStAndBookAndTransactionTypeOrderByIdDesc(st,book.get(0),TransactionType.ISSUE);


        Transaction returnTransaction=Transaction.builder().
                transactionId(UUID.randomUUID().toString()).
                book(book.get(0)).
                st(st).
                payment(calculateFine(IssueTransaction)).build();
        return returnTransaction.getTransactionId();
    }

    private int calculateFine(Transaction issueTxn){
        long issueTime = issueTxn.getTransactionTime().getTime();
        long returnTime = System.currentTimeMillis();

        long diff = returnTime - issueTime;
        long daysPassed = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);


        if(daysPassed >= 14) {
            return (int) ((daysPassed - 14) * 1);
        }

        return 0;
    }
}
