package com.example.profiler_demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profiler_demo.model.User;
import com.example.profiler_demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class OptimizedUserService {
    @Autowired
    private UserRepository userRepository;

    // Good Code: Efficiently processing user data with minimal database calls
    @Transactional
    public List<User> getAllUsers() {
    return userRepository.findAll().stream()
        .map(user -> {
            user.setEmail(user.getEmail());  // Process user data as needed
            return user;
        })
        .collect(Collectors.toList());
    }


    // Good Code: Efficient user creation with optimized memory usage
    @Transactional
    public void createUsers(int count) {
        List<User> usersToSave = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUsername("user" + i);
            user.setEmail("user" + i + "@example.com");

            // Batch processing for better database performance
            usersToSave.add(user);
        }

        // Save all users in a single database call
        userRepository.saveAll(usersToSave);

        // Avoid unnecessary memory usage by reusing string literals
    }
}
