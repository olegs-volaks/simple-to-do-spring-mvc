package com.ovolaks.simpletodo.controllers;

import com.ovolaks.simpletodo.application.dto.task.CreateTaskDto;
import com.ovolaks.simpletodo.application.services.task.CreateTaskService;
import com.ovolaks.simpletodo.application.services.task.GetTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TasksController {

    @Autowired
    private CreateTaskService createTaskService;

    @Autowired
    private GetTasksService getTasksService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", getTasksService.execute());
        return "/tasks/index";
    }

    @GetMapping("/task/new")
    public String newTask(CreateTaskDto createTaskDto) {
        return "/tasks/new";
    }

    @PostMapping("/task/new")
    public String createTask(@Valid CreateTaskDto createTaskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/tasks/new";
        }
        createTaskService.execute(createTaskDto);
        return "redirect:/";
    }

}
