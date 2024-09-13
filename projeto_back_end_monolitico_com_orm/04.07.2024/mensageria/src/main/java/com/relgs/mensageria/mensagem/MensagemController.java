package com.relgs.mensageria.mensagem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    private MensagemRepository mensagemRepository;

    @GetMapping
    public List<Mensagem> getAllMensagens() {
        return mensagemRepository.findAll();
    }

    @PostMapping
    public Mensagem createMensagem(@RequestBody Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }
}
