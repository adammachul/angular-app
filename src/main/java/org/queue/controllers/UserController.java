package org.queue.controllers;

import org.queue.models.User;
import org.queue.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@RequestParam String id) {
        User user = userRepository.getOne(id);
        return user;
    }
}
