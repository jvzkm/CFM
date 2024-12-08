package com.train.app.dao.repository;

import com.train.app.model.entity.TrainLoadedVagon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainLoadedVagonRepository extends JpaRepository<TrainLoadedVagon, Integer>{
}