package com.example.LMS.Request;


import com.example.LMS.Models.AccontStatus;
import com.example.LMS.Models.Book;
import com.example.LMS.Models.Student;
import com.example.LMS.Models.Transaction;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    @NotNull
    private String name;

    @NotBlank
    private String contact;

    @NotNull
    private String email;

    private String address;

    public Student to(){
        return new Student().builder().
                name(name).
                contact(contact).
                email(email).
                address(address).
                acStatus(AccontStatus.ACTIVE).
                build();
    }
}
