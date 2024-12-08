package com.train.app.dao.repository;

import com.train.app.model.entity.PassDocumentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassDocumentDataRepository extends JpaRepository<PassDocumentData, String> {
}