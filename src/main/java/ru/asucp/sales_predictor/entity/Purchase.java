package ru.asucp.sales_predictor.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private ZonedDateTime date;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    /**
     * Устанавливает дату с московской временной зоной по умолчанию.
     */
    @PrePersist
    public void setDefaultTimeZone() {
        if (date == null) {
            date = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        }
    }
}
