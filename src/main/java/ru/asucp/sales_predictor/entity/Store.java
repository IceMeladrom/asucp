package ru.asucp.sales_predictor.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "nearest_warehouse_id", nullable = false)
    private Warehouse nearestWarehouse;

    @OneToMany(mappedBy = "store")
    private List<Purchase> purchases;
}
