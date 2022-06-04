package com.ovolaks.simpletodo.application.repositories;

import com.ovolaks.simpletodo.application.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByIdAndUser_Id(Long id, Long userId);

    List<Task> findByUser_IdOrderByIdDesc(Long userId);


}