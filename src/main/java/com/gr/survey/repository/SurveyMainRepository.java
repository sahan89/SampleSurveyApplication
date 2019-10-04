package com.gr.survey.repository;

import com.gr.survey.model.SurveyMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyMainRepository extends JpaRepository<SurveyMain, Integer> {
}
