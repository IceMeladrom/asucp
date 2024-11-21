package ru.asucp.sales_predictor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PredictionService {
    private final WebClient webClient;
    private final String pythonApiUri = "http://127.0.0.1:5000/predict";

    public Mono<Double> predict(Long warehouseId, String product, LocalDate startDate, LocalDate endDate) {
        Map<String, Object> requestData = Map.of(
                "warehouseId", warehouseId,
                "product", product,
                "startDate", startDate.toString(),
                "endDate", endDate.toString()
        );

        return this.webClient.post()
                .uri(pythonApiUri)
                .bodyValue(requestData)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Double) response.get("prediction"));
    }
}
