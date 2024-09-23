package com.example.profiler_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.profiler_demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
