package com.jagodawieczorek.todoapp.task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    TaskCommand save(TaskCommand task);
}