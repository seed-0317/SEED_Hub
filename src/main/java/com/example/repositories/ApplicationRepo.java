package com.example.repositories;

import com.example.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by uzh051 on 5/4/17.
 */

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Integer> {

    Application  findByApplicantUId(int id);

    List<Application> findAll();


    Application save(Application application);
}
