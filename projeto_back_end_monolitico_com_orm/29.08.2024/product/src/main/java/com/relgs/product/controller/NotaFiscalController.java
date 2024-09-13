package com.relgs.product.controller;

import com.relgs.product.dto.NotaFiscalDto;
import com.relgs.product.service.NotaFiscalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/nota-fiscal")
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    @GetMapping("/desconto")
    public ResponseEntity<List<NotaFiscalDto>> getByDesconto(@RequestParam BigDecimal desconto) {
        List<NotaFiscalDto> notas = notaFiscalService.findByDesconto(desconto);
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/desconto/greater-than")
    public ResponseEntity<List<NotaFiscalDto>> getByDescontoGreaterThan(@RequestParam BigDecimal desconto) {
        List<NotaFiscalDto> notas = notaFiscalService.findByDescontoGreaterThan(desconto);
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/order-by-valor-unit")
    public ResponseEntity<List<NotaFiscalDto>> getAllOrderedByValorUnitDesc() {
        List<NotaFiscalDto> notas = notaFiscalService.findAllOrderedByValorUnitDesc();
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/top-by-quantidade")
    public ResponseEntity<NotaFiscalDto> getTop1ByOrderByQuantidadeDesc() {
        NotaFiscalDto nota = notaFiscalService.findTop1ByOrderByQuantidadeDesc();
        return ResponseEntity.ok(nota);
    }

    @GetMapping("/quantidade/greater-than")
    public ResponseEntity<List<NotaFiscalDto>> getByQuantidadeGreaterThan(@RequestParam Integer quantidade) {
        List<NotaFiscalDto> notas = notaFiscalService.findByQuantidadeGreaterThan(quantidade);
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/valor-total/greater-than")
    public ResponseEntity<List<NotaFiscalDto>> getByValorTotalGreaterThanOrderByValorTotalDesc(
            @RequestParam BigDecimal valor) {
        List<NotaFiscalDto> notas = notaFiscalService.findByValorTotalGreaterThanOrderByValorTotalDesc(valor);
        return ResponseEntity.ok(notas);
    }
}
