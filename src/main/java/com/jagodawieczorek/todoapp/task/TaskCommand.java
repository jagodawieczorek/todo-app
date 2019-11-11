package com.jagodawieczorek.todoapp.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskCommand {
    private String id;
    private String name;
    private String description;
}