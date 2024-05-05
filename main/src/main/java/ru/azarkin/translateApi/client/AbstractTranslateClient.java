package ru.azarkin.translateApi.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public abstract class AbstractTranslateClient {
    private final RestTemplate restTemplate;
    private final String url;

    public AbstractTranslateClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public abstract List<String> sendRequests(List<Object> bodies);

    protected String sendRequest(Object data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(data, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }
}
