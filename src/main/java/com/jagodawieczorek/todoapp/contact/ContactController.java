package com.jagodawieczorek.todoapp.contact;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String getPage(Model model)
    {
        return "contact";
    }
}