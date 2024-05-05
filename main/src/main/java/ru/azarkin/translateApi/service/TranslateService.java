package ru.azarkin.translateApi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.azarkin.translateApi.client.AsyncTranslateClient;
import ru.azarkin.translateApi.client.ClientRequestDto;
import ru.azarkin.translateApi.controller.TranslateSpec;
import ru.azarkin.translateApi.converter.TranslateConverter;
import ru.azarkin.translateApi.dto.TranslateRequestDto;
import ru.azarkin.translateApi.exception.DeserializationException;
import ru.azarkin.translateApi.model.LanguageCode;
import ru.azarkin.translateApi.model.TranslateRequest;
import ru.azarkin.translateApi.repository.TranslateRepository;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TranslateService {
    private final TranslateRepository repository;
    private final TranslateConverter converter;
    private final AsyncTranslateClient client;
    private final ObjectMapper objectMapper;

    @Transactional
    public List<String> translate(TranslateRequestDto translateRequestDto, String remoteAddr) {
        log.info("Translating from {}", remoteAddr);

        TranslateRequest saved = create(translateRequestDto, remoteAddr);
        return translateByWords(saved.getText(), saved.getFrom(), saved.getTo());
    }

    private List<String> translateByWords(String text, LanguageCode from, LanguageCode to) {
        List<Object> requestDtos = Arrays.stream(text.split("\\P{L}+"))
                .map(word -> new ClientRequestDto(List.of(word), from, to))
                .collect(Collectors.toList());

        return client.sendRequests(requestDtos).stream()
                .map(json -> {
                    try {
                        return objectMapper.readValue(json, String[].class)[0];
                    } catch (IOException e) {
                        throw new DeserializationException("Error deserializing JSON", e);
                    }
                })
                .toList();
    }

    private TranslateRequest create(TranslateRequestDto translateRequestDto, String remoteAddr) {
        TranslateRequest entity = converter.toEntity(translateRequestDto);
        entity.setIp(remoteAddr);
        entity.setCreatedDate(Instant.now());
        return repository.save(entity);
    }

    public List<TranslateRequestDto> findAll(TranslateSpec spec, Pageable pageable) {
        return repository.findAll(spec, pageable).stream().map(converter::toDto).toList();
    }
}

