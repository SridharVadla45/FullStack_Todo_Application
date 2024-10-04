package com.java_dev.todo_list.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student_tbl")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,targetEntity = Todo.class)
    @JoinColumn(name = "todo_id" ,referencedColumnName = "todoId")
    private List<Todo> TodoList;

}
