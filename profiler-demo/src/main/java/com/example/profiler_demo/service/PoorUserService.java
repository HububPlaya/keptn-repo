package com.example.profiler_demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profiler_demo.model.User;
import com.example.profiler_demo.repository.UserRepository;

@Service
public class PoorUserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();  // Retrieve all users

        // Process each user individually with unnecessary database lookups
        for (User user : users) {
            simulateHeavyProcessing();  // Simulate unnecessary heavy processing
            Optional<User> dbUser = userRepository.findById(user.getId());  // Inefficient database call
            user.setEmail(dbUser.get().getEmail());
        }
        return users;
    }

    // Simulate a heavy processing task (e.g., complex calculations or data transformation)
    private void simulateHeavyProcessing() {
        try {
            // Artificial delay to simulate performance issues
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Poor Code: Inefficient handling of user creation
    public void createUsers(int count) {
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUsername("user" + i);
            user.setEmail("user" + i + "@example.com");

            // Saving users one by one could lead to database bottlenecks
            userRepository.save(user);

            // Inefficient memory usage: creating new String objects in a loop
            String email = new String("user" + i + "@example.com");
            user.setEmail(email);
        }
    }
   
}
