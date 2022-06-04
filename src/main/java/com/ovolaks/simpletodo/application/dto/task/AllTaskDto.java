package com.ovolaks.simpletodo.application.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllTaskDto implements Serializable {
    private Long userId;
}
