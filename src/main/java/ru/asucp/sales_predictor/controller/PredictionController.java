package ru.asucp.sales_predictor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.asucp.sales_predictor.dto.ModelDataDto;
import ru.asucp.sales_predictor.service.PredictionService;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public Mono<String> predict(@ModelAttribute ModelDataDto modelDataDto, Model model) {
        Long warehouseId = modelDataDto.getWarehouseId();
        Long productId = modelDataDto.getProductId();

        ZoneId moscowZone = ZoneId.of("Europe/Moscow");

        ZonedDateTime startDate = modelDataDto.getStartDate().atZone(moscowZone);
        ZonedDateTime endDate = modelDataDto.getEndDate().atZone(moscowZone);

        return predictionService.predict(warehouseId, productId, startDate, endDate)
                .map(prediction -> {
                    model.addAttribute("prediction", prediction);
                    return "index";
                });
    }
}
