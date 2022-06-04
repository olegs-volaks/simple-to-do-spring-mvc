package com.ovolaks.simpletodo.application.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable {
    private Long id;

    @NotBlank(message = "Name can not be blank")
    private String name;
    private String description;
    private boolean completed;
    private Long userId;
}
