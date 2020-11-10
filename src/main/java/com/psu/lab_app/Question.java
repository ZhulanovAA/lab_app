package com.psu.lab_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Question {
    private @Id @GeneratedValue Long id;
    @Column(length = 2000)
    private String text;

    public Question() {}

    public Question(String text) {
        this.text = text;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
