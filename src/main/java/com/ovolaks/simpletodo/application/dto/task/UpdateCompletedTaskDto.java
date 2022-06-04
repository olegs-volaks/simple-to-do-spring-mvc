package com.ovolaks.simpletodo.application.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompletedTaskDto implements Serializable {
    private Long id;
    private boolean completed;
    private Long userId;
}
