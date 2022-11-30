package com.example.LMS.Request;

import com.example.LMS.Models.Author;
import com.example.LMS.Models.Book;
import com.example.LMS.Models.Genre;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookRequest {
    @Positive
    private int cost;

    @NotBlank
    private String name;

    @NotNull
    private Genre genre;

    @NotNull
    private Author author;

    public Book to(){
        return Book.builder().
                cost(this.cost).
                name(this.name).genre(this.genre).auth(this.author).build();
    }

}
