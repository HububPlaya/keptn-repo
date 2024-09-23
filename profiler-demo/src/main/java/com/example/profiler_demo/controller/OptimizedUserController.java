package com.example.profiler_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.profiler_demo.model.User;
import com.example.profiler_demo.service.OptimizedUserService;

@RestController
@RequestMapping("/optimized")
public class OptimizedUserController {
    @Autowired
    private OptimizedUserService optimizedUserService;

    @GetMapping("/users")
    public List<User> _getAllUsers() {
        return optimizedUserService.getAllUsers();
    }
    
    @PostMapping("/users/create")
    public void _createUsers(@RequestParam int count) {
        optimizedUserService.createUsers(count);
    }
}
