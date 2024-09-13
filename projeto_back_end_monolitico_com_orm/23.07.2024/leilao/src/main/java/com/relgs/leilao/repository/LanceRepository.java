package com.relgs.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relgs.leilao.model.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {
    
}
