package com.train.app.dao.repository;

import com.train.app.model.entity.VagonClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagonClassRepository extends JpaRepository<VagonClass, String>{
}