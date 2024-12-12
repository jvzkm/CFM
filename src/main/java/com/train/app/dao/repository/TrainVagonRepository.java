package com.train.app.dao.repository;


import com.train.app.model.entity.TrainVagon;
import com.train.app.model.entity.Vagon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainVagonRepository extends JpaRepository<TrainVagon, Integer> {
    @Query("select t.vagon from TrainVagon t where t.trainLoadedVagons.id = ?1")
    List<Vagon> getVagonsByTravel(Integer id);
}