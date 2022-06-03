package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.CreateTaskDto;
import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDto execute(CreateTaskDto createTaskDto) {
        Task newTask = new Task();
        newTask.setName(createTaskDto.getName());
        newTask.setDescription(createTaskDto.getDescription());
        Task savedTask = taskRepository.save(newTask);

        return new TaskDto(savedTask.getId(), savedTask.getName(), savedTask.getDescription(), savedTask.isCompleted());
    }
}
