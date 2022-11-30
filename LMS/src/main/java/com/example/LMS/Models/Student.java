package com.example.LMS.Models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true,nullable = false)
    private String contact;

    @Column(unique = true)
    private String email;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private AccontStatus acStatus;

    @OneToMany(mappedBy = "student")
    private List<Book> books;


    @OneToMany(mappedBy = "st")
    private List<Transaction> transactions;

}
