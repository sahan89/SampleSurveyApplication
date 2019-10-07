package com.gr.survey.repository;

import com.gr.survey.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUsersByUsernameAndStatusNot(String username, int status);

    Users findUsersByUsernameAndPasswordAndStatus(String username, String password, int status);
}
