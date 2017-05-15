package com.example.repositories;

import com.example.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface QuestionsRepo extends JpaRepository<Question, Integer> {

    Question findByQId(int qId);

    List<Question> findBySeedClassCIdAndQType(int cId, String qType);

    Question save(Question question);
}
