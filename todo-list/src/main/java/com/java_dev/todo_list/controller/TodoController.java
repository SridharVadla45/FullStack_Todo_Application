package com.java_dev.todo_list.controller;

import com.java_dev.todo_list.dto.TodoDto;
import com.java_dev.todo_list.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/student/{emailId}/todo", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;

    // create task
    @PostMapping("/create")
    public ResponseEntity<String> createTodo(@RequestBody TodoDto todoDto, @PathVariable String emailId) {

        try {

            todoService.create(todoDto, emailId);
            return ResponseEntity.status(HttpStatus.CREATED).body("todo created successfully ");

        } catch (NoSuchElementException e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provide valid emailId , No such emailId present in database ");

        } catch (Exception e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error while creating a todo");
        }

    }

    // view task list

    @GetMapping("/{todoId}")
    public ResponseEntity<Object> viewTodo(@PathVariable String emailId, @PathVariable Long todoId) {
        try {
            TodoDto todo = todoService.viewTodo(todoId, emailId);
            return ResponseEntity.status(HttpStatus.OK).body(todo);
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


    }

    // Edit task
    @PutMapping("/{todoId}/edit")
    public ResponseEntity<String> editTodo(@RequestBody TodoDto todoDto, @PathVariable String emailId, @PathVariable Long todoId) {

        try {

            todoService.editTodo(todoDto, emailId, todoId);
            return ResponseEntity.status(HttpStatus.CREATED).body("todo updated successfully ");

        } catch (NoSuchElementException e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (Exception e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    // complete tasks
    @PutMapping("/{todoId}")
    public ResponseEntity<String> markTodoAsComplete(@PathVariable String emailId, @PathVariable Long todoId) {

        try {

            todoService.completeTask(todoId,emailId);
            return ResponseEntity.status(HttpStatus.CREATED).body("todo marked as completed ");

        } catch (NoSuchElementException e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (Exception e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    //Delete task
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> DeleteTodo(@PathVariable String emailId, @PathVariable Long todoId) {
        try {

            todoService.deleteTask(todoId,emailId);
            return ResponseEntity.status(HttpStatus.CREATED).body("todo deleted successfully ");

        } catch (NoSuchElementException e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (Exception e) {

            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
