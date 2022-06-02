package com.ovolaks.simpletodo.application.services.authentication;

import com.ovolaks.simpletodo.application.entities.User;
import com.ovolaks.simpletodo.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager implements UserDetailsManager {

    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDetails user) {
        userRepository.save((User) user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = authenticationFacade.getAuthentication();
        if (currentUser == null) {
        }

    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return user.get();
    }
}
