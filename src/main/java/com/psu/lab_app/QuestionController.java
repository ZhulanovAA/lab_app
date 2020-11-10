package com.psu.lab_app;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    private final QuestionRepository repository;

    QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/questions")
    List<Question> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return repository.save(newQuestion);
    }

    // Single item

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/questions/{id}")
    Question one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    @PutMapping("/questions/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {

        return repository.findById(id)
                .map(question -> {
                    question.setText(newQuestion.getText());
                    return repository.save(question);
                })
                .orElseGet(() -> {
                    newQuestion.setId(id);
                    return repository.save(newQuestion);
                });
    }

    @DeleteMapping("/questions/{id}")
    void deleteQuestion(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
