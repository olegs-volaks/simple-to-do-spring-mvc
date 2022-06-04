package com.ovolaks.simpletodo.application.services.task;

import com.ovolaks.simpletodo.application.dto.task.CreateTaskDto;
import com.ovolaks.simpletodo.application.dto.task.TaskDto;
import com.ovolaks.simpletodo.application.entities.Task;
import com.ovolaks.simpletodo.application.entities.User;
import com.ovolaks.simpletodo.application.repositories.TaskRepository;
import com.ovolaks.simpletodo.application.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CreateTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public TaskDto execute(@NotNull CreateTaskDto createTaskDto) {
        Optional<User> currentUserOptional = userRepository.findById(createTaskDto.getUserId());
        TaskDto response = new TaskDto();
        if (currentUserOptional.isPresent()) {
            User currentUser = currentUserOptional.get();
            Task newTask = new Task();
            newTask.setName(createTaskDto.getName());
            newTask.setDescription(createTaskDto.getDescription());
            newTask.setUser(currentUser);
            Task savedTask = taskRepository.save(newTask);

            response.setId(savedTask.getId());
            response.setName(savedTask.getName());
            response.setDescription(savedTask.getDescription());
            response.setCompleted(savedTask.isCompleted());
            response.setUserId(currentUser.getId());
        }

        return response;
    }
}
