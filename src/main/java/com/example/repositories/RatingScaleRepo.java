package com.example.repositories;

import com.example.model.RatingScale;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingScaleRepo {

    List<RatingScale> findAll();
    RatingScale findByRsId(int rsId);
}
