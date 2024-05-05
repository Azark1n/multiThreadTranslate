package ru.azarkin.translateApi.converter;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.azarkin.translateApi.dto.TranslateRequestDto;
import ru.azarkin.translateApi.model.TranslateRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TranslateConverter {
    TranslateRequest toEntity(TranslateRequestDto dto);
    TranslateRequestDto toDto(TranslateRequest entity);
}