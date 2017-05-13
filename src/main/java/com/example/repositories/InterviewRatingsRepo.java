package com.example.repositories;

import com.example.model.InterviewRatings;
import com.example.model.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface InterviewRatingsRepo extends JpaRepository<InterviewRatings, Integer> {
    InterviewRatings findByRatId(int ratId);
    List<InterviewRatings> findByInterviewIntId(int intId);
    InterviewRatings save(InterviewRatings interviewRatings);
}
