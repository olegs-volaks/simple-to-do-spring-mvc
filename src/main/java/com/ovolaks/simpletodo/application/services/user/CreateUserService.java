package com.ovolaks.simpletodo.application.services.user;

import com.ovolaks.simpletodo.application.dto.UserDto;
import com.ovolaks.simpletodo.application.services.authentication.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    private UserManager userManager;

    public UserDto execute(UserDto userDto) {
        return null;
    }
}
