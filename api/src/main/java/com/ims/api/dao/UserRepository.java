package com.ims.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries or methods can be added if needed
}