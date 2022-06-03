package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDto execute(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        TaskDto response = new TaskDto();
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            response.setId(task.getId());
            response.setName(task.getName());
            response.setDescription(task.getDescription());
            task.setCompleted(task.isCompleted());
        }
        return response;
    }
}
