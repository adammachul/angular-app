package org.queue.initializer;

import org.queue.models.Lists;
import org.queue.models.roles.Roles;
import org.queue.models.User;
import org.queue.repositories.ListsRepository;
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

    @Autowired
    private ListsRepository listsRepository;

    @Override
    public void run(String... args) throws Exception {
        User adminUser = userRepository.save(makeAdminUser());
        User regularUser = userRepository.save(makeRegularUser());
        logger.info("Users have been initialized");
        listsRepository.save(makeFirstList(adminUser));
        listsRepository.save(makeSecondList(regularUser));
        logger.info("Lists have been initialized");
    }

    private Lists makeFirstList(User user) {
        Lists firstList = new Lists();
        firstList.setName("Jedzenie");
        firstList.setDescription("To lista z jedzeniem");
        String[] elements = {"pierwsze jedzenie", "drugie jedzenie"};
        firstList.addElements(elements);
        firstList.setUser(user);
        return firstList;
    }

    private Lists makeSecondList(User user) {
        Lists secondList = new Lists();
        secondList.setName("Leki");
        secondList.setDescription("To lista lekow");
        String[] elements = {"pierwszy lek", "drugi lek"};
        secondList.addElements(elements);
        secondList.setUser(user);
        return secondList;
    }

    private User makeAdminUser() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin"); //TODO: change it to MD5
        admin.setEmail("admin@listonic.com");
        admin.addRoles(Roles.ROLE_ADMIN);
        return admin;
    }

    private User makeRegularUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("user"); //TODO: change it to MD5
        user.setEmail("user@listonic.com");
        user.addRoles(Roles.ROLE_USER);
        return user;
    }
}
