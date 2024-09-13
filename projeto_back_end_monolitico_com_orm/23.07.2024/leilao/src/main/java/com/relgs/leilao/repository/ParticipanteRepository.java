package com.relgs.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relgs.leilao.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    
}
