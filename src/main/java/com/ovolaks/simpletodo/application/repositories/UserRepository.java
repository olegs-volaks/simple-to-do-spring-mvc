package com.ovolaks.simpletodo.application.repositories;

import com.ovolaks.simpletodo.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);


}