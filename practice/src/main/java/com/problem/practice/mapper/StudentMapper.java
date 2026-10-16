package com.problem.practice.mapper;

import com.problem.practice.dto.StudentResponse;
import com.problem.practice.model.Student;

public class StudentMapper {

    public static StudentResponse toResponse(Student student){

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getAge()
        );
    }
}
