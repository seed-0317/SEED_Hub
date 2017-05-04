package com.example.repositories;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User  findByUId(int uId);
    User  findByeid(String eId);

    List<User> findAll();
}

