package com.relgs.product.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.relgs.product.dto.NotaFiscalDto;
import com.relgs.product.mapper.NotaFiscalMapper;
import com.relgs.product.repository.NotaFiscalRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotaFiscalService {

    private final NotaFiscalRepository notaFiscalRepository;
    private final NotaFiscalMapper notaFiscalMapper;

    public List<NotaFiscalDto> findByDesconto(BigDecimal desconto) {
        return notaFiscalRepository.findByDesconto(desconto).stream()
                .map(notaFiscalMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDto> findByDescontoGreaterThan(BigDecimal desconto) {
        return notaFiscalRepository.findByDescontoGreaterThan(desconto).stream()
                .map(notaFiscalMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDto> findAllOrderedByValorUnitDesc() {
        return notaFiscalRepository.findAllByOrderByValorUnitDesc().stream()
                .map(notaFiscalMapper::toDto)
                .collect(Collectors.toList());
    }

    public NotaFiscalDto findTop1ByOrderByQuantidadeDesc() {
        return notaFiscalMapper.toDto(notaFiscalRepository.findTop1ByOrderByQuantidadeDesc());
    }

    public List<NotaFiscalDto> findByQuantidadeGreaterThan(Integer quantidade) {
        return notaFiscalRepository.findByQuantidadeGreaterThan(quantidade).stream()
                .map(notaFiscalMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDto> findByValorTotalGreaterThanOrderByValorTotalDesc(BigDecimal valor) {
        return notaFiscalRepository.findByValorTotalGreaterThanOrderByValorTotalDesc(valor).stream()
                .map(notaFiscalMapper::toDto)
                .collect(Collectors.toList());
    }
}
