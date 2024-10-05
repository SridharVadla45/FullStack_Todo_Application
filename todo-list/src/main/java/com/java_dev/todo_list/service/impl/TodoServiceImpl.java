package com.java_dev.todo_list.service.impl;

import com.java_dev.todo_list.dto.TodoDto;
import com.java_dev.todo_list.mapper.TodoMapper;
import com.java_dev.todo_list.model.Student;
import com.java_dev.todo_list.model.Todo;
import com.java_dev.todo_list.repository.StudentRepository;
import com.java_dev.todo_list.repository.TodoRepository;
import com.java_dev.todo_list.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final StudentRepository studentRepository;

    @Override
    public void create(TodoDto todoDto, String emailId) {

        Todo todo = TodoMapper.TodoDtoToTodo(todoDto, new Todo());
        Student student = studentRepository.findByEmailId(emailId).orElseThrow(() -> new NoSuchElementException("No Student with given emailId :" + emailId));
        todo.setStudent(student);
        Long todoId = todoRepository.save(todo).getTodoId();
        log.info("todo saved to database with todoId : {}", todoId);


    }

    @Override
    public TodoDto viewTodo(Long todoId, String emailId) {
        Student student = studentRepository.findByEmailId(emailId)
                .orElseThrow(() -> new NoSuchElementException("No Student with given emailId :" + emailId));
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("No Todo with given todoId :" + todoId));
        return TodoMapper.TodoToTodoDto(todo,new TodoDto());
    }

    @Override
    public void editTodo(TodoDto todoDto,String emailId,Long todoId) {
        Student student = studentRepository.findByEmailId(emailId)
                .orElseThrow(() -> new NoSuchElementException("No Student with given emailId :" + emailId));
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("No Todo with given todoId :" + todoId));
        TodoMapper.TodoDtoToTodo(todoDto,todo);
        todoRepository.save(todo);
        log.info("todo  updated with given details for todoId : {}", todoId);
    }

    @Override
    public void completeTask(Long todoId,String emailId) {
        Student student = studentRepository.findByEmailId(emailId)
                .orElseThrow(() -> new NoSuchElementException("No Student with given emailId :" + emailId));
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("No Todo with given todoId :" + todoId));
        todo.setCompleted(true);
        todoRepository.save(todo);
        log.info("todo  marked as completed  for todoId : {}", todoId);
    }

    @Override
    public void deleteTask(Long todoId,String emailId) {
        Student student = studentRepository.findByEmailId(emailId)
                .orElseThrow(() -> new NoSuchElementException("No Student with given emailId :" + emailId));
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("No Todo with given todoId :" + todoId));
        todoRepository.deleteById(todoId);
        log.info("todo  marked as completed  for todoId : {}", todoId);


    }
}
