package com.example.repositories;

import com.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by npw383 on 5/4/17.
 */

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
    List<Role> findAll();
    Role  findByRId(int rid);
    Role save(Role role);
}
