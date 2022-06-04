package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.UpdateCompletedTaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UpdateTaskCompetedService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public void execute(UpdateCompletedTaskDto updateCompletedTaskDto) {
        Optional<Task> taskOptional = taskRepository.findByIdAndUser_Id(updateCompletedTaskDto.getId(), updateCompletedTaskDto.getUserId());
        taskOptional.ifPresent(task -> task.setCompleted(updateCompletedTaskDto.isCompleted()));
    }
}
