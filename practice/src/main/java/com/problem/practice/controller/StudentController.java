package com.problem.practice.controller;


import com.problem.practice.dto.StudentRequest;
import com.problem.practice.dto.StudentResponse;
import com.problem.practice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest){

        StudentResponse studentResponse = studentService.createStudent(studentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id){

        StudentResponse studentResponse = studentService.getStudentById(id);

        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }
}
