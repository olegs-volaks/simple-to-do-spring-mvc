package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.IdTaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DeleteTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public void execute(@NotNull IdTaskDto taskDto) {
        Optional<Task> taskOptional = taskRepository.findByIdAndUser_Id(taskDto.getId(), taskDto.getUserId());
        taskOptional.ifPresent(task -> taskRepository.deleteById(task.getId()));
    }
}
