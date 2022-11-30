package com.example.LMS.Repository;

import com.example.LMS.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

     Author findByName(String name);

}
