package com.jagodawieczorek.todoapp.api;

import com.jagodawieczorek.todoapp.category.Category;
import com.jagodawieczorek.todoapp.category.CategoryService;
import com.jagodawieczorek.todoapp.task.Task;
import com.jagodawieczorek.todoapp.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoAppRestController {
    private final TaskService taskService;
    private final CategoryService categoryService;

    @GetMapping(value = "/tasks", produces = "application/json")
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @GetMapping(value = "/tasks/{id}", produces = "application/json")
    public Task getTaskById(@PathVariable String id) {
        return taskService.findById(id);
    }

    @GetMapping(value = "/categories", produces = "application/json")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping(value = "/categories/{id}", produces = "application/json")
    public Category getCategoryById(@PathVariable String id) {
        return categoryService.findById(id);
    }
}