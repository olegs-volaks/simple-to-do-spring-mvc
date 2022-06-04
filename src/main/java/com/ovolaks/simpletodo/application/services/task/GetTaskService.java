package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.IdTaskDto;
import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GetTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public TaskDto execute(IdTaskDto taskDto) {
        Optional<Task> taskOptional = taskRepository.findByIdAndUser_Id(taskDto.getId(), taskDto.getUserId());
        TaskDto response = new TaskDto();
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            response.setId(task.getId());
            response.setName(task.getName());
            response.setDescription(task.getDescription());
            response.setCompleted(task.isCompleted());
            response.setUserId(taskDto.getUserId());
        }
        return response;
    }
}
