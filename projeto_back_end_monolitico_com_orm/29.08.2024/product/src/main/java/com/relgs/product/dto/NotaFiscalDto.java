package com.relgs.product.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.relgs.product.model.NotaFiscal}
 */
public record NotaFiscalDto(Integer id, Integer idNf, Integer idItem, Integer codProd, BigDecimal valorUnit,
                            Integer quantidade, BigDecimal desconto) implements Serializable {
}