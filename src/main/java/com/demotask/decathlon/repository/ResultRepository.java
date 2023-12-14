package com.demotask.decathlon.repository;

import com.demotask.decathlon.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> findAllByAthletId(int athletId);

    @Query("SELECT SUM(points) FROM Result where athlet=:athletId")
    Double athletPointSum(int athletId);
}
