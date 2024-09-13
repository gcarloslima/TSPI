package com.relgs.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relgs.leilao.model.ItemDeLeilao;
import com.relgs.leilao.repository.ItemDeLeilaoRepository;

@Service
public class ItemDeLeilaoService {

    @Autowired
    public ItemDeLeilaoRepository repository;

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ItemDeLeilao findById(Long id) {
        return repository.findById(id).get();
    }

    public ItemDeLeilao update(Long id, ItemDeLeilao itemDeLeilao) {
        itemDeLeilao.setId(id);
        return repository.save(itemDeLeilao);
    }

    public ItemDeLeilao save(ItemDeLeilao itemDeLeilao) {
        return repository.save(itemDeLeilao);
    }

    public List<ItemDeLeilao> findAll() {
        return repository.findAll();
    }

}
