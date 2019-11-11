package com.jagodawieczorek.todoapp.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfiguration {

    @Bean
    TaskService taskService(TaskRepository taskRepository) {
        return new TaskService(taskRepository);
    }
}