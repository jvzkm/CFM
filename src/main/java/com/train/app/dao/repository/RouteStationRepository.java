package com.train.app.dao.repository;

import com.train.app.model.dto.TrainLineInfo;
import com.train.app.model.entity.Route;
import com.train.app.model.entity.RouteStation;
import com.train.app.model.entity.Station;
import com.train.app.model.entity.TrainLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteStationRepository extends JpaRepository<RouteStation, Integer> {

    @Query("select r.lineElement.station from RouteStation r where r.stationIndex between ?1 and ?2 and r.route.id = ?3")
    List<Station> getStationsInBetween(Integer stationIndexStart, Integer stationIndexEnd, Integer routeId);

    @Query("SELECT r FROM RouteStation r WHERE r.lineElement.station.id = :station AND r.route = :route")
    Optional<RouteStation> findByStationAndRoute(@Param("station") Integer station, @Param("route") Route route);

    @Query("select MAX(r.stationIndex) from RouteStation r where r.route.id = ?1")
    Integer findLastIndexByRoute(Integer id);

    Optional<RouteStation> findByRouteAndStationIndex(Route route, int i);

    @Query("select r from RouteStation r where r.route = ?1 and r.stationIndex = ?2")
    Optional<RouteStation> findByIndexAndRoute(Route route, Integer stationIndex);

    @Query("select r.stationIndex from RouteStation r where r.route.id = ?1 and r.lineElement.station.id = ?2")
    Optional<Integer> getIndexByStation(Integer id, Integer id1);

    @Query("SELECT new com.train.app.model.dto.TrainLineInfo(r.lineElement.trainLine, COUNT(r)) " +
            "FROM RouteStation r " +
            "WHERE r.stationIndex >= :start AND r.stationIndex <= :end AND r.route = :route " +
            "GROUP BY r.lineElement.trainLine")
    List<TrainLineInfo> getTrainLinesInBetweenStationsWithCount(@Param("start") Integer startIndex, @Param("end") Integer endIndex, @Param("route") Route route);


}