package ru.azarkin.translateApi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.azarkin.translateApi.dto.TranslateRequestDto;
import ru.azarkin.translateApi.service.TranslateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TranslateController {
    public static final String URI_PATH = "/translate";
    private final TranslateService service;

    @PostMapping(URI_PATH)
    public List<String> translate(@RequestBody @Valid TranslateRequestDto translateRequest, HttpServletRequest request) {
        return service.translate(translateRequest, request.getRemoteAddr());
    }

    @GetMapping(URI_PATH)
    public List<TranslateRequestDto> findAll(TranslateSpec spec, Pageable pageable) {
        return service.findAll(spec, pageable);
    }
}