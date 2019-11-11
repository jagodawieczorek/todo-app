package com.jagodawieczorek.todoapp.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;
}
