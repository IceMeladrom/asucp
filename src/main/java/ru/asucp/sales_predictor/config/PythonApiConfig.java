package ru.asucp.sales_predictor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "python.api")
@Data
public class PythonApiConfig {
    private String url;

}
