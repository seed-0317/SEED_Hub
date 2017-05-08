package com.example.repositories;

import com.example.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nof191 on 5/4/17.
 */

@Repository

public interface InterviewRepo extends JpaRepository<Interview, Integer> {

    Interview findByIntId(int intId);

    List<Interview> findByApplicantUId(int applicantUId);

    List<Interview> findAll();

    Interview save(Interview inteerview);
}
