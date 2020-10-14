package com.psu.lab_app;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    private final QuestionRepository repository;

    QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/questions")
    List<Question> all() {
        return repository.findAll();
    }
}
