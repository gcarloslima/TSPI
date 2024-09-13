package com.relgs.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relgs.leilao.model.Lance;
import com.relgs.leilao.repository.LanceRepository;

@Service
public class LanceService {

    @Autowired
    public LanceRepository repository;

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Lance findById(Long id) {
        return repository.findById(id).get();
    }

    public Lance update(Long id, Lance lance) {
        lance.setId(id);
        return repository.save(lance);
    }

    public List<Lance> findAll() {
        return repository.findAll();
    }

}
