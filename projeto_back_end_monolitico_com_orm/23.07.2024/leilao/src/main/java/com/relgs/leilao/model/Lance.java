package com.relgs.leilao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Lance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long valor;

    @OneToOne
    private Participante participante;

}
