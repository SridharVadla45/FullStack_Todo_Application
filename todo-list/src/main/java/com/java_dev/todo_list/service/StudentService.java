package com.java_dev.todo_list.service;

import com.java_dev.todo_list.dto.StudentDto;
import org.springframework.stereotype.Service;


public interface StudentService {

    void register(StudentDto studentDto);

}
