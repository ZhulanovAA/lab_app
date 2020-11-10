package com.psu.lab_app;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(Long id) {
        super("Could not find question " + id);
    }
}
