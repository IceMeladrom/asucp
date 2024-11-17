package ru.asucp.sales_predictor.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.util.TimeZone;

@Configuration
public class TimeZoneConfig {

    @PostConstruct
    public void init() {
        // Устанавливаем московскую временную зону по умолчанию
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Europe/Moscow")));
    }
}
