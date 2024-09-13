package br.edu.iftm.tspi.entregas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.entregas.model.Pacote;
import br.edu.iftm.tspi.entregas.model.Rastreamento;
import br.edu.iftm.tspi.entregas.repository.PacoteRepository;
import br.edu.iftm.tspi.entregas.repository.RastreamentoRepository;

@Service
public class RastreamentoService {
    
    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    @Autowired
    private PacoteRepository pacoteRepository;

    public String save(Rastreamento rastreamento, Long idPacote) {
        Optional<Pacote> pacote = pacoteRepository.findById(idPacote);

        if (pacote.isPresent()) {
            Pacote pacoteAtualizado = pacote.get();
            Rastreamento novoRastreamento = rastreamentoRepository.save(rastreamento);
            pacoteAtualizado.atualizarStatus(novoRastreamento);
            pacoteRepository.save(pacoteAtualizado);
            return novoRastreamento.getResumo();
        } else {
            return null;
        }
    }

    public List<Rastreamento> findByPacote(Long idPacote) {
        Optional<Pacote> pacote = pacoteRepository.findById(idPacote);
        if (pacote.isPresent()) {
            return pacote.get().getRastreamento();
        } else {
            return null;
        }
    }

}
