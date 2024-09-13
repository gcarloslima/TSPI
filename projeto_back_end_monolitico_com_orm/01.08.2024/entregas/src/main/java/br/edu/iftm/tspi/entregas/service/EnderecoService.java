package br.edu.iftm.tspi.entregas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.entregas.model.Endereco;
import br.edu.iftm.tspi.entregas.model.Pacote;
import br.edu.iftm.tspi.entregas.repository.EnderecoRepository;
import br.edu.iftm.tspi.entregas.repository.PacoteRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PacoteRepository pacoteRepository;

    public Endereco findByPacote(Long idPacote) {
        Optional<Pacote> pacote = pacoteRepository.findById(idPacote);
        if (pacote.isPresent()) {
            return pacote.get().getEndereco();
        } else {
            return null;
        }
    }

    public String save(Endereco endereco, Long idPacote) {
        Optional<Pacote> pacote = pacoteRepository.findById(idPacote);

        if (pacote.isPresent()) {
            Pacote pacoteAtualizado = pacote.get();
            Endereco novoEndereco = enderecoRepository.save(endereco);
            pacoteAtualizado.setEndereco(endereco);
            pacoteRepository.save(pacoteAtualizado);
            return novoEndereco.getEnderecoCompleto();
        } else {
            return null;
        }
    }

}
