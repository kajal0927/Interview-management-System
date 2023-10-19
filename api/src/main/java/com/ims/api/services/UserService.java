package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.UserRepository;
import com.ims.api.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    user.setRole(updatedUser.getRole());
                    user.setEmail(updatedUser.getEmail());
                    user.setName(updatedUser.getName());
                    user.setPhone(updatedUser.getPhone());
                    user.setAddress(updatedUser.getAddress());
                    user.setActive(updatedUser.isActive());
                    user.setLastLogin(updatedUser.getLastLogin());
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
