package com.train.app.dao.repository;

import com.train.app.model.entity.TrainLine;
import com.train.app.model.entity.TrainLineElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainLineElementRepository extends JpaRepository<TrainLineElement, Integer> {
    @Query("SELECT e FROM TrainLineElement e WHERE e.trainLine = :trainLine ORDER BY e.km DESC LIMIT 1")
    TrainLineElement findLastElementByTrainLine(@Param("trainLine") TrainLine trainLine);
}