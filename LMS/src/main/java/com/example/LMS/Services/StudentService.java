package com.example.LMS.Services;

import com.example.LMS.Models.Student;
import com.example.LMS.Repository.StudentRepository;
import com.example.LMS.Request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public Student createStudent(StudentRequest studentRequest){
        Student studentFromDB=studentRepository.save(studentRequest.to());
        return studentFromDB;
    }

    public Student findStudent(int studentid){
        return studentRepository.findById(studentid).orElse(null);
    }

}
