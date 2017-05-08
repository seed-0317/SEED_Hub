package com.example.repositories;

import com.example.model.StatusChange;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by npw383 on 5/4/17.
 */
@Repository
public interface StatusChangeRepo extends JpaRepository<StatusChange,Integer> {
    List<StatusChange> findByUserUId(int uId);
    StatusChange findByShId(int shId);
    List<StatusChange> findAll();
    StatusChange save(StatusChange statusChange);
}
