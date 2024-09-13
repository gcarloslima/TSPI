package com.relgs.product.repository;

import com.relgs.product.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer>, JpaSpecificationExecutor<NotaFiscal> {

    List<NotaFiscal> findByDesconto(BigDecimal desconto);

    List<NotaFiscal> findByDescontoGreaterThan(BigDecimal desconto);

    List<NotaFiscal> findAllByOrderByValorUnitDesc();

    NotaFiscal findTop1ByOrderByQuantidadeDesc();

    List<NotaFiscal> findByQuantidadeGreaterThan(Integer quantidade);

    @Query(value = "SELECT nf.* FROM nota_fiscal nf WHERE (nf.valor_unit * nf.quantidade) > :valor ORDER BY (nf.valor_unit * nf.quantidade) DESC", nativeQuery = true)
    List<NotaFiscal> findByValorTotalGreaterThanOrderByValorTotalDesc(@Param("valor") BigDecimal valor);

}