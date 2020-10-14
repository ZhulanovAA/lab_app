package com.psu.lab_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(QuestionRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Question("Решите уравнение x*2 = 10")));
            log.info("Preloading " + repository.save(new Question("Решите уравнение x*3 = 30")));
        };
    }
}