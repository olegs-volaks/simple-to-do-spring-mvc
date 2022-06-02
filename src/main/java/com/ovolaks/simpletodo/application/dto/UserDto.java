package com.ovolaks.simpletodo.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
}
