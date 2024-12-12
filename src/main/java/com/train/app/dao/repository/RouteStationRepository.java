package com.train.app.dao.repository;

import com.train.app.model.dto.TrainLineInfo;
import com.train.app.model.entity.Route;
import com.train.app.model.entity.RouteStation;
import com.train.app.model.entity.TrainLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteStationRepository extends JpaRepository<RouteStation, Integer> {

    @Query("select r from RouteStation r where r.route = ?1 and r.stationIndex = ?2")
    Optional<RouteStation> findByIndexAndRoute(Route route, Integer stationIndex);

    @Query("SELECT DISTINCT r.lineElement.trainLine FROM RouteStation r WHERE r.stationIndex >= :start and r.stationIndex <=:end and r.route = :route")
    List<TrainLine> getTrainLinesInBetweenStations(@Param("start") Integer startIndex, @Param("end") Integer endIndex, @Param("route") Route route);

    @Query("SELECT new com.app.train.model.entity.TrainLineInfo(r.lineElement.trainLine, COUNT(r)) " +
            "FROM RouteStation r " +
            "WHERE r.stationIndex >= :start AND r.stationIndex <= :end AND r.route = :route " +
            "GROUP BY r.lineElement.trainLine")
    List<TrainLineInfo> getTrainLinesInBetweenStationsWithCount(@Param("start") Integer startIndex, @Param("end") Integer endIndex, @Param("route") Route route);


}