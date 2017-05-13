package com.example.repositories;

import com.example.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface InterviewRepo extends JpaRepository<Interview, Integer> {

    Interview findByIntId(int intId);

    List<Interview> findByApplicantUId(int applicantUId);

    List<Interview> findAll();

    Interview save(Interview inteerview);
}
