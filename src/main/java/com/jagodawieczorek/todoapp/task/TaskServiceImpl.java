package com.jagodawieczorek.todoapp.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        Task savedTask = taskRepository.save(task);
        log.debug("Saved task:" + savedTask.getId());

        return savedTask;
    }
}
