package org.queue.initializer;

import org.queue.models.roles.Roles;
import org.queue.models.User;
import org.queue.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(UserInitializer.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(makeAdminUser());
        userRepository.save(makeRegularUser());
        logger.info("Users have been initialized");
    }

    private User makeAdminUser() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin"); //TODO: change it to MD5
        admin.setEmail("admin@online-pharmacy.com");
        admin.addRoles(Roles.ROLE_ADMIN);
        return admin;
    }

    private User makeRegularUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("user"); //TODO: change it to MD5
        user.setEmail("user@online-pharmacy.com");
        user.addRoles(Roles.ROLE_USER);
        return user;
    }
}
