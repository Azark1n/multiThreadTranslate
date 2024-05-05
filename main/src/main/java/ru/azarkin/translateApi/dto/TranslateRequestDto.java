package ru.azarkin.translateApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.azarkin.translateApi.model.LanguageCode;

import java.time.Instant;

@Data
@ToString(callSuper = true)
public final class TranslateRequestDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private LanguageCode from;

    @NotNull
    private LanguageCode to;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String ip;
}
