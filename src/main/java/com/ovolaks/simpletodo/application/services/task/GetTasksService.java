package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.AllTaskDto;
import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetTasksService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public List<TaskDto> execute(@NotNull AllTaskDto taskDto) {
        List<Task> tasks = taskRepository.findByUser_IdOrderByIdDesc(taskDto.getUserId());
        List<TaskDto> response = new ArrayList<>();
        tasks.forEach(task -> response.add(new TaskDto(task.getId(), task.getName(), task.getDescription(), task.isCompleted(), taskDto.getUserId())));
        return response;
    }

}
