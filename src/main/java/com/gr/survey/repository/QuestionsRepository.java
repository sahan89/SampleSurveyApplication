package com.gr.survey.repository;

import com.gr.survey.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
    List<Questions> findAllByStatusNot(int status);
}
