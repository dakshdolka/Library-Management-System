package com.example.LMS.Repository;

import com.example.LMS.Models.Book;
import com.example.LMS.Models.Student;
import com.example.LMS.Models.Transaction;
import com.example.LMS.Models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

 Transaction findTopByStAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);

}

