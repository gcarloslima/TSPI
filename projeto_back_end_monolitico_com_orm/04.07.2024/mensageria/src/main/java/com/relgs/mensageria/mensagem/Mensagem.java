package com.relgs.mensageria.mensagem;

import java.util.Date;

import com.relgs.mensageria.mensagemcorpo.MensagemCorpo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assunto;
    private Date dataEnvio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mensagem_corpo_id", referencedColumnName = "id")
    private MensagemCorpo mensagemCorpo;

}
