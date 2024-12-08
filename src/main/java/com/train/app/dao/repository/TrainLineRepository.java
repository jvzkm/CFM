package com.train.app.dao.repository;

import com.train.app.model.entity.TrainLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainLineRepository extends JpaRepository<TrainLine, Integer> {
}