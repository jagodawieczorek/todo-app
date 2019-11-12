package com.jagodawieczorek.todoapp.bootstrap;

import com.jagodawieczorek.todoapp.category.Category;
import com.jagodawieczorek.todoapp.category.CategoryRepository;
import com.jagodawieczorek.todoapp.task.Task;
import com.jagodawieczorek.todoapp.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TasksBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<Category> categories = saveCategories();
        saveTasks(categories);
    }

    private void saveTasks(List<Category> categories) {
        int tasksCount = 5;
        List<Task> tasks = new ArrayList<>(tasksCount);

        for (int i = 1; i <= tasksCount; i++) {
            tasks.add(new Task(Integer.toString(i), "Test name", "Test description", categories.get(2), null, new Date(System.currentTimeMillis())));
        }

        taskRepository.saveAll(tasks);
    }

    private List<Category> saveCategories() {
        List<Category> categories = new ArrayList<>(3);

        categories.add(new Category("1", "House"));
        categories.add(new Category("2", "School"));
        categories.add(new Category("3", "Work"));

        categoryRepository.saveAll(categories);

        return categories;
    }
}
