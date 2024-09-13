package br.edu.iftm.tspi.entregas.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rastreamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRastreamento;

    private Date dataHora;

    private String status;

    private String localizacao;

    @JsonIgnore
    public String getResumo() {
        return String.format("Status: %s,%nLocalização: %s,%nData: %s,%n", status, localizacao, dataHora.toString());
    }

}
