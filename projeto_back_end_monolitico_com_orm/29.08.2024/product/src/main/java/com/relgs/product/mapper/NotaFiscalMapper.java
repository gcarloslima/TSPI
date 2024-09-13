package com.relgs.product.mapper;

import com.relgs.product.dto.NotaFiscalDto;
import com.relgs.product.model.NotaFiscal;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotaFiscalMapper {
    NotaFiscal toEntity(NotaFiscalDto notaFiscalDto);

    NotaFiscalDto toDto(NotaFiscal notaFiscal);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NotaFiscal partialUpdate(NotaFiscalDto notaFiscalDto, @MappingTarget NotaFiscal notaFiscal);
}