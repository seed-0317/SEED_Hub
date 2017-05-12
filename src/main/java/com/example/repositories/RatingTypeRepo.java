package com.example.repositories;

import com.example.model.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RatingTypeRepo extends JpaRepository<RatingType, Integer > {

    RatingType findByRtId(int rtId);
    RatingType save(RatingType ratingType);

}
