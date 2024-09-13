package com.relgs.product.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('nota_fiscal_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_nf")
    private Integer idNf;

    @Column(name = "id_item")
    private Integer idItem;

    @Column(name = "cod_prod")
    private Integer codProd;

    @Column(name = "valor_unit", precision = 10, scale = 2)
    private BigDecimal valorUnit;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "desconto", precision = 5, scale = 2)
    private BigDecimal desconto;

}