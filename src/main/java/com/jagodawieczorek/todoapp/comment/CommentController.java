package com.jagodawieczorek.todoapp.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("")
    public String save(@ModelAttribute Comment comment) {
        commentService.save(comment);

        return "redirect:/tasks/list";
    }

    @RequestMapping({"/create/"})
    public String create(Model model) {
        model.addAttribute("comment", new Comment());

        return "tasks/form/comment";
    }
}