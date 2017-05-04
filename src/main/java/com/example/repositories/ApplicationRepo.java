package com.example.repositories;

import com.example.model.Application;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by uzh051 on 5/4/17.
 */
public interface ApplicationRepo extends JpaRepository<Application, Integer> {

    Application  findByuid(int id);
}
