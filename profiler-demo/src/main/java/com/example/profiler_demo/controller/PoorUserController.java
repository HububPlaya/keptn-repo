package com.example.profiler_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.profiler_demo.model.User;
import com.example.profiler_demo.service.PoorUserService;

@RestController
@RequestMapping("/poor")
public class PoorUserController {

    @Autowired
    private PoorUserService poorUserService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return poorUserService.getAllUsers();
    }
    
    @PostMapping("/users/create")
    public void createUsers(@RequestParam int count) {
        poorUserService.createUsers(count);
    }
}
