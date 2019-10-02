package com.gr.survey.repository;

import com.gr.survey.model.CallStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallStatusRepository extends JpaRepository<CallStatus, Integer> {
}
