package com.jagodawieczorek.todoapp.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @RequestMapping({"/tasks", "tasks/list"})
    public String getList(Model model)
    {
        return "tasks/list";
    }
}
