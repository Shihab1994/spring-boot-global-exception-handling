package com.problem.practice.service;

import com.problem.practice.dto.StudentRequest;
import com.problem.practice.dto.StudentResponse;
import com.problem.practice.exception.StudentNotFoundException;
import com.problem.practice.mapper.StudentMapper;
import com.problem.practice.model.Student;
import com.problem.practice.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //post api
    public StudentResponse createStudent(StudentRequest studentRequest) {

        Student student = new Student();

        student.setName(studentRequest.name());
        student.setAge(studentRequest.age());

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.toResponse(savedStudent);
    }

    //get api
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        return StudentMapper.toResponse(student);
    }

}
