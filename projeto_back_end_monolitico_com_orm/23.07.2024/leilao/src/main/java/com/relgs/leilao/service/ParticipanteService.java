package com.relgs.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relgs.leilao.model.Participante;
import com.relgs.leilao.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

    @Autowired
    public ParticipanteRepository repository;

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Participante findById(Long id) {
        return repository.findById(id).get();
    }

    public Participante update(Long id, Participante participante) {
        participante.setId(id);
        return repository.save(participante);
    }

    public Participante save(Participante participante) {
        return repository.save(participante);
    }

    public List<Participante> findAll() {
        return repository.findAll();
    }

}
