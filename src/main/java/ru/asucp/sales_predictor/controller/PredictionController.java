package ru.asucp.sales_predictor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.asucp.sales_predictor.dto.ModelDataDto;
import ru.asucp.sales_predictor.service.PredictionService;

import java.time.LocalDate;
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
        String product = modelDataDto.getProduct();

        ZoneId moscowZone = ZoneId.of("Europe/Moscow");

        LocalDate startDate = modelDataDto.getStartDate();
        LocalDate endDate = modelDataDto.getEndDate();

        return predictionService.predict(warehouseId, product, startDate, endDate)
                .map(prediction -> {
                    model.addAttribute("prediction", prediction);
                    return "index";
                });
    }
}
