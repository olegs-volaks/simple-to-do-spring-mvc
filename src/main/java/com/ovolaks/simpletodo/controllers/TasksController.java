package com.ovolaks.simpletodo.controllers;

import com.ovolaks.simpletodo.application.dto.task.*;
import com.ovolaks.simpletodo.application.entities.User;
import com.ovolaks.simpletodo.application.services.task.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TasksController {

    @Autowired
    private CreateTaskService createTaskService;
    @Autowired
    private GetTasksService getTasksService;
    @Autowired
    private GetTaskService getTaskService;
    @Autowired
    private UpdateTaskService updateTaskService;
    @Autowired
    private UpdateTaskCompetedService updateTaskCompetedService;
    @Autowired
    private DeleteTaskService deleteTaskService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User currentUser, Model model) {
        AllTaskDto request = new AllTaskDto(currentUser.getId());
        model.addAttribute("tasks", getTasksService.execute(request));
        return "/tasks/index";
    }

    @GetMapping("/task/new")
    public String newTask(CreateTaskDto createTaskDto) {
        return "/tasks/new";
    }

    @PostMapping("/task/new")
    public String createTask(@AuthenticationPrincipal User currentUser, @Valid CreateTaskDto createTaskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/tasks/new";
        }
        createTaskDto.setUserId(currentUser.getId());
        createTaskService.execute(createTaskDto);
        return "redirect:/";
    }

    @GetMapping("/task/{id}/edit")
    public String editTask(@AuthenticationPrincipal User currentUser, @PathVariable long id, TaskDto taskDto) {
        TaskDto response = getTaskService.execute(new IdTaskDto(id, currentUser.getId()));
        if (response.getId() == null) {
            return "redirect:/";
        }
        taskDto.setId(response.getId());
        taskDto.setName(response.getName());
        taskDto.setDescription(response.getDescription());
        taskDto.setCompleted(taskDto.isCompleted());
        return "/tasks/edit";
    }

    @PostMapping("/task/{id}/edit")
    public String update(@AuthenticationPrincipal User currentUser, @PathVariable long id, @Valid TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/tasks/edit";
        }
        taskDto.setId(id);
        taskDto.setUserId(currentUser.getId());
        updateTaskService.execute(taskDto);
        return "redirect:/";
    }

    @GetMapping("/task/{id}/complete")
    public String complete(@AuthenticationPrincipal User currentUser, @PathVariable long id) {
        UpdateCompletedTaskDto request = new UpdateCompletedTaskDto(id, true, currentUser.getId());
        updateTaskCompetedService.execute(request);
        return "redirect:/";
    }

    @GetMapping("/task/{id}/delete")
    public String delete(@AuthenticationPrincipal User currentUser, @PathVariable long id) {
        IdTaskDto request = new IdTaskDto(id, currentUser.getId());
        deleteTaskService.execute(request);
        return "redirect:/";
    }
}
