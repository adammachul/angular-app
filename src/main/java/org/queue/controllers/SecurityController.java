package org.queue.controllers;

import org.queue.models.User;
import org.queue.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user")
    public User user(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return user;
    }

}
