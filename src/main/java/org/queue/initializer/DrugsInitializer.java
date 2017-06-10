package org.queue.initializer;

import org.queue.models.Drug;
import org.queue.repositories.DrugRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class DrugsInitializer implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(DrugsInitializer.class);

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public void run(String... args) throws Exception {
        InputStream stream = this.getClass().getResourceAsStream("/drugs.txt");
        InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        bufferedReader.lines().forEach(line -> {
            drugRepository.save(getDrug(line));
        });
        logger.info("Drugs have been initialized");
    }

    private Drug getDrug(String line) {
        String[] split = line.split(";");
        Drug drug = new Drug();
        drug.setId(split[0]);
        drug.setName(split[1]);
        drug.setCompany(split[2]);
        drug.setDescription(split[3]);
        drug.setPrice(new Double(split[4]));
        drug.setImage(split[5]);
        return drug;
    }

}
