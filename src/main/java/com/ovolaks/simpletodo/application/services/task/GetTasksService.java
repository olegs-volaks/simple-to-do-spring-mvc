package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetTasksService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDto> execute() {
        List<Task> tasks = taskRepository.findAllByOrderByIdDesc();
        List<TaskDto> response = new ArrayList<>();
        tasks.forEach(task -> response.add(new TaskDto(task.getId(), task.getName(), task.getDescription(), task.isCompleted())));
        return response;
    }

}
