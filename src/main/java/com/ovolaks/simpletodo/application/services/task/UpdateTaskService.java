package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UpdateTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public void execute(TaskDto taskDto) {
        Optional<Task> taskOptional = taskRepository.findByIdAndUser_Id(taskDto.getId(), taskDto.getUserId());
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            task.setCompleted(taskDto.isCompleted());
        }
    }
}
