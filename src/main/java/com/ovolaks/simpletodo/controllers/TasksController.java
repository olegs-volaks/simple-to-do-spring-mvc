package com.ovolaks.simpletodo.controllers;

import com.ovolaks.simpletodo.application.dto.task.CreateTaskDto;
import com.ovolaks.simpletodo.application.dto.task.IdTaskDto;
import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.dto.task.UpdateCompletedTaskDto;
import com.ovolaks.simpletodo.application.services.task.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/task/{id}/edit")
    public String editTask(@PathVariable long id, TaskDto taskDto) {
        TaskDto dto = getTaskService.execute(id);
        if (dto.getId() == null) {
            return "redirect:/";
        }
        taskDto.setId(dto.getId());
        taskDto.setName(dto.getName());
        taskDto.setDescription(dto.getDescription());
        taskDto.setCompleted(taskDto.isCompleted());
        return "/tasks/edit";
    }

    @PostMapping("/task/{id}/edit")
    public String update(@PathVariable long id, @Valid TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/tasks/edit";
        }
        taskDto.setId(id);
        updateTaskService.execute(taskDto);
        return "redirect:/";
    }

    @GetMapping("/task/{id}/complete")
    public String complete(@PathVariable long id) {
        updateTaskCompetedService.execute(new UpdateCompletedTaskDto(id, true));
        return "redirect:/";
    }

    @GetMapping("/task/{id}/delete")
    public String delete(@PathVariable long id) {
        deleteTaskService.execute(new IdTaskDto(id));
        return "redirect:/";
    }
}
