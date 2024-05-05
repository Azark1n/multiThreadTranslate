package ru.azarkin.translateApi.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
public class AsyncTranslateClient extends AbstractTranslateClient {
    private final ExecutorService executorService;

    public AsyncTranslateClient(@Value("${config.threadPool.size}") int poolSize, @Value("${config.translator.url}") String translatorUrl) {
        super(new RestTemplate(), translatorUrl);
        this.executorService = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public List<String> sendRequests(List<Object> bodies) {
        List<CompletableFuture<String>> futures = new ArrayList<>();

        for (Object body : bodies) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> sendRequest(body), executorService);
            futures.add(future);
        }

        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
