package com.gr.survey.repository;

import com.gr.survey.model.ResearchNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResearchNumberRepository extends JpaRepository<ResearchNumber, Integer> {
}
