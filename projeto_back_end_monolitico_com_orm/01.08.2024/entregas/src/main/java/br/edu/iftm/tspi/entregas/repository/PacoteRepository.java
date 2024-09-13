package br.edu.iftm.tspi.entregas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.tspi.entregas.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {
    
}
