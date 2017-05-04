package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by njb917 on 5/4/17.
 */
@Repository
public interface SeedClass extends JpaRepository<SeedClass, Integer> {
}


