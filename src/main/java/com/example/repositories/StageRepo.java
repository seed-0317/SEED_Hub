package com.example.repositories;

import com.example.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by npw383 on 5/4/17.
 */

@Repository
public interface StageRepo extends JpaRepository<Stage, Integer> {
    List<Stage> findAll();
    Stage findBySId(int sid);
    Stage save(Stage stage);
}