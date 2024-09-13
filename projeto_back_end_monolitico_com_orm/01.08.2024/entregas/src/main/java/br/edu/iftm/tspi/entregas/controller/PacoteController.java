package br.edu.iftm.tspi.entregas.controller;

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

import br.edu.iftm.tspi.entregas.model.Pacote;
import br.edu.iftm.tspi.entregas.service.PacoteService;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {
    
    @Autowired
    private PacoteService pacoteService;

    @GetMapping
    public List<Pacote> findAll() {
        return pacoteService.findAll();
    }

    @PostMapping
    public Pacote save(@RequestBody(required = true) Pacote pacote) {
        return pacoteService.save(pacote);
    }

    @GetMapping("/{id}")
    public Pacote findById(@PathVariable Long id) {
        return pacoteService.findById(id);
    }

    @PutMapping("/{id}")
    public Pacote update(@RequestBody Pacote pacote, @PathVariable Long id) {
        return pacoteService.update(pacote, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return pacoteService.delete(id);
    }

}
