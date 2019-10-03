package com.gr.survey.repository;

import com.gr.survey.model.ResponseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseStatusRepository extends JpaRepository<ResponseStatus, Integer> {
}
