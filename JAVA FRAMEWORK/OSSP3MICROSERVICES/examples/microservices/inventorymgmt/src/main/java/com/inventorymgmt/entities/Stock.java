package com.inventorymgmt.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock")
@Data
public class Stock {
    @Id
    @Column(name = "stock_unique_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockUniqueNo;
    @Column(name = "product_nm")
    private String productName;
    private String category;
    @Column(name = "model_no")
    private String modelNo;
    private int quantity;
    private double price;

}
