package com.ovolaks.simpletodo.application.repositories;

import com.ovolaks.simpletodo.application.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    @Modifying
    @Query("update Task t set t.completed = ?1 where t.id = ?2")
    int updateCompletedById(boolean completed, Long id);

    List<Task> findAllByOrderByIdDesc();
}