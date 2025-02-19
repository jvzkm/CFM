package com.train.app.dao.repository;

import com.train.app.model.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {
    @Query("select t from Travel t where t.route.id = ?1 and FUNCTION('DATE', t.startDateTime) = ?2")
    List<Travel> findByDateAndRoute(Integer routeId, LocalDate startDate);
}