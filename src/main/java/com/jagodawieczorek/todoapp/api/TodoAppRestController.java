package com.jagodawieczorek.todoapp.api;

import com.jagodawieczorek.todoapp.category.Category;
import com.jagodawieczorek.todoapp.category.CategoryService;
import com.jagodawieczorek.todoapp.task.Task;
import com.jagodawieczorek.todoapp.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TodoAppRestController {
    private final TaskService taskService;
    private final CategoryService categoryService;

    @GetMapping(value = "/tasks")
    public ResponseEntity<CollectionModel<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAll();
        tasks.forEach(task -> task.add(linkTo(TodoAppRestController.class).slash("tasks").slash(task.getId()).withSelfRel()));
        Link link = linkTo(TodoAppRestController.class).slash("tasks").withSelfRel();
        CollectionModel<Task> taskCollectionModel = new CollectionModel<>(tasks, link);
        return new ResponseEntity<>(taskCollectionModel, HttpStatus.OK);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<EntityModel<Task>> getTaskById(@PathVariable String id) {
        Link link = linkTo(TodoAppRestController.class).slash("tasks").slash(id).withSelfRel();
        Task task = taskService.findById(id);
        EntityModel<Task> taskEntityModel = new EntityModel<>(task, link);
        return new ResponseEntity<>(taskEntityModel, HttpStatus.OK);
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<CollectionModel<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAll();
        categories.forEach(category -> category.add(linkTo(TodoAppRestController.class).slash("categories").slash(category.getId()).withSelfRel()));
        Link link = linkTo(TodoAppRestController.class).slash("categories").withSelfRel();
        CollectionModel<Category> categoryCollectionModel = new CollectionModel<>(categories, link);
        return new ResponseEntity<>(categoryCollectionModel, HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<EntityModel<Category>> getCategoryById(@PathVariable String id) {
        Link link = linkTo(TodoAppRestController.class).slash("categories").slash(id).withSelfRel();
        Category category = categoryService.findById(id);
        EntityModel<Category> categoryEntityModel = new EntityModel<>(category, link);
        return new ResponseEntity<>(categoryEntityModel, HttpStatus.OK);
    }
}