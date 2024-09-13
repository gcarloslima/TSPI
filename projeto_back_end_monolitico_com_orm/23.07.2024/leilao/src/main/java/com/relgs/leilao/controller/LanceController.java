package com.relgs.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relgs.leilao.model.Lance;
import com.relgs.leilao.service.LanceService;

@RestController
@RequestMapping("lance")
public class LanceController {

    @Autowired
    public LanceService service;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Lance findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Lance update(@PathVariable Long id, @RequestBody Lance lance) {
        return service.update(id, lance);
    }

    @GetMapping
    public List<Lance> findAll() {
        return service.findAll();
    }

}
