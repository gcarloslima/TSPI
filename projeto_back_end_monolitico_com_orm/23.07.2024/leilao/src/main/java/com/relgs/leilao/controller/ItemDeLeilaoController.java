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

import com.relgs.leilao.model.ItemDeLeilao;
import com.relgs.leilao.service.ItemDeLeilaoService;

@RestController
@RequestMapping("itemdeleilao")
public class ItemDeLeilaoController {

    @Autowired
    public ItemDeLeilaoService service;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public ItemDeLeilao findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ItemDeLeilao update(@PathVariable Long id, @RequestBody ItemDeLeilao itemDeLeilao) {
        itemDeLeilao.setId(id);
        return service.save(itemDeLeilao);
    }

    @PostMapping
    public ItemDeLeilao save(@RequestBody ItemDeLeilao itemDeLeilao) {
        return service.save(itemDeLeilao);
    }

    @GetMapping
    public List<ItemDeLeilao> findAll() {
        return service.findAll();
    }

}
