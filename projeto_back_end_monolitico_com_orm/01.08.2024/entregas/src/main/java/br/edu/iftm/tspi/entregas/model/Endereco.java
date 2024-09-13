package br.edu.iftm.tspi.entregas.model;

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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    private String rua;

    private String numero;

    private String cidade;

    private String estado;

    private String cep;

    @JsonIgnore
    public String getEnderecoCompleto() {
        return String.format("Rua: %s,%nNúmero: %s,%nCidade: %s,%nEstado: %s,%nCEP: %s%n",rua, numero, cidade, estado, cep);
    }

}
