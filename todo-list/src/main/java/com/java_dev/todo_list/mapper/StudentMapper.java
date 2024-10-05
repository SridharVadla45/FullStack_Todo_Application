package com.java_dev.todo_list.mapper;

import com.java_dev.todo_list.dto.StudentDto;
import com.java_dev.todo_list.model.Student;
import org.springframework.stereotype.Component;


public class StudentMapper {

    public static Student StudentDtoToStudent(StudentDto studentDto , Student student){

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmailId(studentDto.getEmailId());
        student.setPassword(studentDto.getPassword());

        return student;
    }
}
