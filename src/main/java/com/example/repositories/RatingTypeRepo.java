package com.example.repositories;

import com.example.model.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nof191 on 5/4/17.
 */

@Repository
public interface RatingTypeRepo extends JpaRepository<RatingType, Integer > {
}
