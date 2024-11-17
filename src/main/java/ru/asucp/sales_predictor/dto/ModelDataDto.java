package ru.asucp.sales_predictor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDataDto {
    private Long productId;
    private Long warehouseId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
