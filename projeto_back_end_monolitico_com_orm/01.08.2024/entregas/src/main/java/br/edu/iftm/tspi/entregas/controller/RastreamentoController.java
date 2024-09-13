package br.edu.iftm.tspi.entregas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.entregas.model.Rastreamento;
import br.edu.iftm.tspi.entregas.service.RastreamentoService;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @PostMapping
    public String save(@RequestBody(required = true) Rastreamento rastreamento, @RequestParam Long id) {
        return rastreamentoService.save(rastreamento, id);
    }

    @GetMapping("/{id}")
    public List<Rastreamento> findByPacote(@PathVariable Long id) {
        return rastreamentoService.findByPacote(id);
    }

}
