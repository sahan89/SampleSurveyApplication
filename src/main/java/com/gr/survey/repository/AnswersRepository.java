package com.gr.survey.repository;

import com.gr.survey.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Integer> {
    List<Answers> findAll();
}
