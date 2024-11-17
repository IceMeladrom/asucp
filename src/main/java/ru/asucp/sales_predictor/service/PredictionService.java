package ru.asucp.sales_predictor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PredictionService {
    private final WebClient webClient;

    public Mono<Double> predict(Long warehouseId, Long productId, ZonedDateTime startDate, ZonedDateTime endDate) {
        Map<String, Object> requestData = Map.of(
                "warehouseId", warehouseId,
                "productId", productId,
                "startDate", startDate,
                "endDate", endDate
        );

        return this.webClient.post()
                .uri("/predict")
                .bodyValue(requestData)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Double) response.get("prediction"));
    }
}
