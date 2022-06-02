package com.ovolaks.simpletodo.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final boolean completed;
}
