package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.IdTaskDto;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void execute(IdTaskDto taskDto) {
        taskRepository.deleteById(taskDto.getId());
    }
}
