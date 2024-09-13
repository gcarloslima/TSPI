package com.relgs.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relgs.leilao.model.Participante;
import com.relgs.leilao.repository.ParticipanteRepository;

@RestController
@RequestMapping("participante")
public class ParticipanteController {

    @Autowired
    public ParticipanteRepository repository;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Participante findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/{id}")
    public Participante update(@PathVariable Long id, @RequestBody Participante participante) {
        participante.setId(id);
        return repository.save(participante);
    }

    @PostMapping
    public Participante save(@RequestBody Participante participante) {
        return repository.save(participante);
    }

    @GetMapping
    public List<Participante> findAll() {
        return repository.findAll();
    }

}
