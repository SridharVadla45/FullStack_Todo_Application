package com.java_dev.todo_list.service;

import com.java_dev.todo_list.dto.TodoDto;

public interface TodoService {

    void create(TodoDto todoDto, String emailId);

    TodoDto viewTodo(Long todoId, String emailId);

    void editTodo(TodoDto todoDto,String emailId,Long todoID);

    void completeTask(Long todoId,String emailId);

    void deleteTask(Long todoId,String emailId);


}
