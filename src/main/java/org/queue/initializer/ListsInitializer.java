package org.queue.initializer;

import org.queue.models.Lists;
import org.queue.repositories.ListsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class ListsInitializer implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(ListsInitializer.class);

    @Autowired
    private ListsRepository listsRepository;

    @Override
    public void run(String... args) throws Exception {
        listsRepository.save(makeFirstList());
        listsRepository.save(makeSecondList());
        logger.info("Lists have been initialized list initializer dziala");
    }

    private Lists makeFirstList() {
        Lists firstList = new Lists();
        firstList.setName("Jedzenie");
        firstList.setDescription("To lista z jedzeniem");
        String[] elements = {"pierwsze jedzenie", "drugie jedzenie"};
        firstList.addElements(elements);
        return firstList;
    }

    private Lists makeSecondList() {
        Lists secondList = new Lists();
        secondList.setName("Leki");
        secondList.setDescription("To lista lekow");
        String[] elements = {"ppierwszy lek", "drugi lek"};
        secondList.addElements(elements);
        return secondList;
    }
}
