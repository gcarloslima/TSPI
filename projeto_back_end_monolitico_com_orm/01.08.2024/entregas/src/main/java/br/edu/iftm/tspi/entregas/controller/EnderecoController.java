package br.edu.iftm.tspi.entregas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.entregas.model.Endereco;
import br.edu.iftm.tspi.entregas.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public Endereco findByPacote(@PathVariable Long id) {
        return enderecoService.findByPacote(id);
    }

    @PostMapping
    public String save(@RequestBody(required = true) Endereco endereco, @RequestParam Long id) {
        return enderecoService.save(endereco, id);
    }

}
