package com.gr.survey.repository;

import com.gr.survey.model.SurveyAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyAnswersRepository extends JpaRepository<SurveyAnswers, Integer> {
}
