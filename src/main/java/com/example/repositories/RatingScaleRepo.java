package com.example.repositories;

import com.example.model.Question;
import com.example.model.RatingScale;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface RatingScaleRepo extends JpaRepository<RatingScale, Integer> {

    List<RatingScale> findAll();
    RatingScale findByRsId(int rsId);
}
