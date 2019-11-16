package com.jagodawieczorek.todoapp.task;

import com.jagodawieczorek.todoapp.category.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final CategoryService categoryService;

    @RequestMapping({"/tasks", "/tasks/", "/tasks/list", "/tasks/list/"})
    public String getList(Model model) {
        model.addAttribute("tasks", taskService.getAll());

        return "tasks/list";
    }

    @RequestMapping({"/tasks/create"})
    public String create(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("statuses", Status.values());

        return "tasks/form";
    }

    @PostMapping("/task")
    public String save(@ModelAttribute Task task) {
        Task savedTask = taskService.save(task);
        // TODO add validation
        return "redirect:/tasks/" + savedTask.getId();
    }

    @GetMapping("/tasks/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("task", taskService.findById(id));

        return "tasks/show";
    }
}
