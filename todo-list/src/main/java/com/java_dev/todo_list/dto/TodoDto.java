package com.java_dev.todo_list.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDto {

    private String title;

    private String description;

    private LocalDateTime deadline;

    private boolean isCompleted;
}
