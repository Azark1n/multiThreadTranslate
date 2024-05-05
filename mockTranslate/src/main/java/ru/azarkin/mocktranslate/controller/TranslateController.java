package ru.azarkin.mocktranslate.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.azarkin.mocktranslate.dto.TranslateRequestDto;
import ru.azarkin.mocktranslate.service.TranslateStrategy;
import ru.azarkin.mocktranslate.service.TranslateStrategyFactory;

import java.util.List;

@RestController
public class TranslateController {
    public static final String URI_PATH = "/translate";

    @PostMapping(URI_PATH)
    public List<String> translate(@RequestBody @Valid TranslateRequestDto translateRequestDto) {
        TranslateStrategy translateStrategy = TranslateStrategyFactory.getTranslateStrategy(
                translateRequestDto.sourceLanguageCode(), translateRequestDto.targetLanguageCode());
        return translateRequestDto.texts().stream().map(translateStrategy::Translate).toList();
    }
}
