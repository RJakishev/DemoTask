package com.demotask.decathlon.repository;

import com.demotask.decathlon.model.Athlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthletRepository extends JpaRepository<Athlet, Integer> {
}
