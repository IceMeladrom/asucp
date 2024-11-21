package ru.asucp.sales_predictor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDataDto {
    private String product;
    private Long warehouseId;
    private LocalDate startDate;
    private LocalDate endDate;
}
