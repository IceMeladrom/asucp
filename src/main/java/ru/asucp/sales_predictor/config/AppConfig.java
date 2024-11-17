package ru.asucp.sales_predictor.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final PythonApiConfig pythonApiConfig;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(pythonApiConfig.getUrl())
                .build();
    }
}
