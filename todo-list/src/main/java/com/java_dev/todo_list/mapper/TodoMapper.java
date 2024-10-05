package com.java_dev.todo_list.mapper;

import com.java_dev.todo_list.dto.TodoDto;
import com.java_dev.todo_list.model.Todo;

public class TodoMapper {

    public static Todo TodoDtoToTodo(TodoDto todoDto , Todo todo){

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDeadline(todoDto.getDeadline());
        todo.setCompleted(todoDto.isCompleted());

        return todo;
    }


    public static TodoDto TodoToTodoDto(Todo todo , TodoDto todoDto){

        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setDeadline(todo.getDeadline());
        todoDto.setCompleted(todo.isCompleted());

        return todoDto;
    }
}
