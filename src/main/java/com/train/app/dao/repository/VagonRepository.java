package com.train.app.dao.repository;

import com.train.app.model.entity.Vagon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagonRepository extends JpaRepository<Vagon, Integer> {
}