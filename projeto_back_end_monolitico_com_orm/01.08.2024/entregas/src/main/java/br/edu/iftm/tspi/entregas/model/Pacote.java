package br.edu.iftm.tspi.entregas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacote;

    private String id;

    private String destinatario;

    private String status;

    @ManyToOne
    private Endereco endereco;

    @OneToMany
    private List<Rastreamento> rastreamento = new ArrayList<>();

    public void atualizarStatus(Rastreamento novoRastreamento) {
        setStatus(novoRastreamento.getStatus());
        rastreamento.add(novoRastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder informacoes = new StringBuilder();

        informacoes.append(String.format("Código de rastreio: %s\nDestinatário: %s\nStatus: %s\nEndereço: %s\n",id, destinatario, status, endereco.getEnderecoCompleto()));

        rastreamento.forEach(rastreio -> {
            informacoes.append(rastreio.getResumo());
        });

        return informacoes.toString();
    }


}
