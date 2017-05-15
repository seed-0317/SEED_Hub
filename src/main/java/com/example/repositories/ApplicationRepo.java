package com.example.repositories;

import com.example.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationRepo extends JpaRepository<Application, Integer> {

    Application  findByApplicantUId(int id);
    Application save(Application application);
    List<Application> findBySeedClassCId(int id);
}
