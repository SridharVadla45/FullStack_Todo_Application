package com.java_dev.todo_list.controller;


import com.java_dev.todo_list.dto.StudentDto;
import com.java_dev.todo_list.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class StudentController {


    private StudentService studentService;


    // register endpoint

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDto studentDto) {

        studentService.register(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("student successfully registered");
    }


}
