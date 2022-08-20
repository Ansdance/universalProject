package com.example.audit.mappers;

import com.example.audit.domain.Just;
import com.example.audit.dto.JustDTO;
import com.example.audit.dto.UpdateJustDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper {

    JustDTO toDTO (Just just);
    @Mapping(target ="id", ignore = true)
    Just toModel (JustDTO justDTO);

    @Mapping(target ="id", ignore = true)
    Just toModel (UpdateJustDTO justDTO);

}
