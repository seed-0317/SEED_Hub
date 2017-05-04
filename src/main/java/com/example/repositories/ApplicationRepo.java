package com.example.repositories;

import com.example.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by uzh051 on 5/4/17.
 */

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Integer> {

    Application  findByApplicantUId(int id);
}
