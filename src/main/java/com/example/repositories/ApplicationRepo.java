package com.example.repositories;

import com.example.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ApplicationRepo extends JpaRepository<Application, Integer> {

    Application  findByApplicantUId(int id);

    Application save(Application application);
}
