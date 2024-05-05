package ru.azarkin.translateApi.client;

import jakarta.validation.constraints.NotNull;
import ru.azarkin.translateApi.model.LanguageCode;

import java.util.List;

public record ClientRequestDto(
        @NotNull List<String> texts,
        @NotNull LanguageCode sourceLanguageCode,
        @NotNull LanguageCode targetLanguageCode) {
}
