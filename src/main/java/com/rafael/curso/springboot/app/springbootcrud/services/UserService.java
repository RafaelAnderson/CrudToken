package com.rafael.curso.springboot.app.springbootcrud.services;

import com.rafael.curso.springboot.app.springbootcrud.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);
}
