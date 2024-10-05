package com.java_dev.todo_list.service.impl;

import com.java_dev.todo_list.dto.StudentDto;
import com.java_dev.todo_list.mapper.StudentMapper;
import com.java_dev.todo_list.model.Student;
import com.java_dev.todo_list.repository.StudentRepository;
import com.java_dev.todo_list.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void register(StudentDto studentDto) {

        try {

            Optional<Student> optionalStudent = studentRepository.findByEmailId(studentDto.getEmailId());

            if (optionalStudent.isPresent())
                throw new RuntimeException("Student with given emailId : " + studentDto.getEmailId() + " alreadly exists ");

            Student student = StudentMapper.StudentDtoToStudent(studentDto, new Student());

            studentRepository.save(student);

            log.info("Student registered successfully ");

        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }


}
