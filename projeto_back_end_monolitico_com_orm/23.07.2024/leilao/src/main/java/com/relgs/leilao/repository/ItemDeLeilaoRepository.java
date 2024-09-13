package com.relgs.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relgs.leilao.model.ItemDeLeilao;

@Repository
public interface ItemDeLeilaoRepository extends JpaRepository<ItemDeLeilao, Long> {
    
}
