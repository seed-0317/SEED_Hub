package com.example.repositories;

import com.example.model.SeedClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SeedClassRepo extends JpaRepository<SeedClass, Integer> {

    SeedClass findByCId(int cId);
    SeedClass save(SeedClass seedClass);
    List<SeedClass> findAll();



}


