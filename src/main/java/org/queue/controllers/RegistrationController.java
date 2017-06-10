package org.queue.controllers;

import org.queue.exceptions.UserAleadyExistsException;
import org.queue.models.User;
import org.queue.models.roles.Roles;
import org.queue.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User registernewUser(@RequestBody User newUser) {
        if (userRepository.findByUsernameAndEmail(newUser.getUsername(), newUser.getEmail()) != null) {
            throw new UserAleadyExistsException();
        }
        newUser.addRoles(Roles.ROLE_USER);

        User resultUser = userRepository.save(newUser);
        logger.info("Added new user [{}]", resultUser.getUsername());
        return resultUser;
    }

    @PostMapping(value = "/username")
    public Boolean isUsernameAlreadyExists(@RequestBody String username) {
        return userRepository.findByUsername(username) != null;
    }

    @PostMapping(value = "/email")
    public Boolean isEmailAlreadyExists(@RequestBody String email) {
        return userRepository.findByEmail(email) != null;
    }
}
