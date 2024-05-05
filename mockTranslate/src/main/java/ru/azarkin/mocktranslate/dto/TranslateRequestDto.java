package ru.azarkin.mocktranslate.dto;

import jakarta.validation.constraints.NotNull;
import ru.azarkin.mocktranslate.model.LanguageCode;

import java.util.List;

public record TranslateRequestDto(
        @NotNull List<String> texts,
        @NotNull LanguageCode sourceLanguageCode,
        @NotNull LanguageCode targetLanguageCode) {
}
