package com.jagodawieczorek.todoapp.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @RequestMapping({"/tasks", "/tasks/", "/tasks/list", "/tasks/list/"})
    public String getList(Model model) {
        model.addAttribute("tasks", taskService.getAll());

        return "tasks/list";
    }

    @RequestMapping({"/tasks/create"})
    public String create(Model model) {
        model.addAttribute("task", new TaskCommand());

        return "tasks/form";
    }

    @PostMapping("task")
    public String save(@ModelAttribute TaskCommand command) {
        // TODO implement saving
        return "redirect:/tasks";
    }
}
