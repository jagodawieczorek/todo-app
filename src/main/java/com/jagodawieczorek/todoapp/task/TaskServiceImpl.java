package com.jagodawieczorek.todoapp.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskCommand save(TaskCommand task) {
        // TODO implement saving (needed to add a converter)
        return null;
    }
}
