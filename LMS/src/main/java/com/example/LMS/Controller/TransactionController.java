package com.example.LMS.Controller;


import com.example.LMS.RecordNotFoundException;
import com.example.LMS.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public String issueBook(@RequestParam("studentId") int studentid,
                          @RequestParam("bookId") int bookId) throws RecordNotFoundException {
       return transactionService.issueBook(studentid,bookId);

    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("studId") int sid,
                             @RequestParam("bookId") int bookId) throws RecordNotFoundException{
        transactionService.returnBook(sid,bookId);
        return "";
    }
}
