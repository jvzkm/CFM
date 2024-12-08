package com.train.app.dao.repository;

import com.train.app.model.entity.BaseTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTicketRepository extends JpaRepository<BaseTicket, Integer> {
}