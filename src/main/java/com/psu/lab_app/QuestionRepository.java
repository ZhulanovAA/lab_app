package com.psu.lab_app;

import org.springframework.data.jpa.repository.JpaRepository;

interface QuestionRepository extends JpaRepository<Question, Long> {

}
