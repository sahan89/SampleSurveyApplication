package com.gr.survey.repository;

import com.gr.survey.model.ResearchNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResearchNumberRepository extends JpaRepository<ResearchNumber, Integer> {
    List<ResearchNumber> findAllByDistrictAndCallStatusAndChecked(String district, int status, int checked);
}
