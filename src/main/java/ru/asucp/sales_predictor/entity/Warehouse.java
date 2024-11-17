package ru.asucp.sales_predictor.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "warehouse")
    private List<Stock> stocks;

    @OneToMany(mappedBy = "nearestWarehouse")
    private List<Store> stores;
}
