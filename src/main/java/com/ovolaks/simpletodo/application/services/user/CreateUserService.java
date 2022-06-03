package com.ovolaks.simpletodo.application.services.user;

import com.ovolaks.simpletodo.application.dto.user.CreateUserDto;
import com.ovolaks.simpletodo.application.entities.Role;
import com.ovolaks.simpletodo.application.entities.User;
import com.ovolaks.simpletodo.application.repositories.RoleRepository;
import com.ovolaks.simpletodo.application.services.authentication.UserManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreateUserService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void execute(@NotNull CreateUserDto createUserDto) {
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setPassword(encoder.encode(createUserDto.getPassword()));
        Set<Role> userRoles = new HashSet<>();
        roleRepository.findByName("user").ifPresent(userRoles::add);
        user.setRoles(userRoles);
        userManager.createUser(user);
    }
}
