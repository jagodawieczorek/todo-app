package com.jagodawieczorek.todoapp.task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task save(Task task);

    Task findById(String id);
}