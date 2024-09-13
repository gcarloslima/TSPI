package br.edu.iftm.tspi.entregas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.entregas.model.Pacote;
import br.edu.iftm.tspi.entregas.repository.PacoteRepository;

@Service
public class PacoteService {
    
    @Autowired
    private PacoteRepository pacoteRepository;

    public List<Pacote> findAll() {
        return pacoteRepository.findAll();
    }

    public Pacote save(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Pacote findById(Long idPacote) {
        Optional<Pacote> pacote = pacoteRepository.findById(idPacote);
        if (pacote.isPresent()) {
            return pacote.get();
        } else {
            return null;
        }
    }

    public Pacote update(Pacote pacote, Long idPacote) {
        pacote.setIdPacote(idPacote);
        return pacoteRepository.save(pacote);
    }

    public String delete(Long idPacote) {
        Optional<Pacote> pacote = pacoteRepository.findById(idPacote);
        if (pacote.isPresent()) {
            pacoteRepository.deleteById(idPacote);
            return "Removido com sucesso!";
        } else {
            return "Pacote não existente";
        }
        
    }

}
