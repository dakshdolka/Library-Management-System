package com.example.LMS.Controller;


import com.example.LMS.Models.Student;
import com.example.LMS.Request.StudentRequest;
import com.example.LMS.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }
}
