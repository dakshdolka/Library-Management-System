package com.example.LMS.Models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int payment;

    @Enumerated
    private TransactionType transactionType;

    private String transactionId;
    @ManyToOne
    @JoinColumn
    private Book book;



    @ManyToOne
    @JoinColumn
    private Student st;

    @CreationTimestamp
    private Date transactionTime;

}
