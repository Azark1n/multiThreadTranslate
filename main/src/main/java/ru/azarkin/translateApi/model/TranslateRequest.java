package ru.azarkin.translateApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "translate_requests")
@Getter
@Setter
public class TranslateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "createdDate")
    private Instant createdDate;

    @Column(name = "text", length = 2048)
    private String text;

    @Column(name = "language_from")
    private LanguageCode from;

    @Column(name = "language_to")
    private LanguageCode to;

    @Column(name = "ip")
    private String ip;
}
