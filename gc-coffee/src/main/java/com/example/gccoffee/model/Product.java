package com.example.gccoffee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    private final UUID productId;
    private String productName;
    private Category category;
    private long price;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(UUID productId, String productName, Category category, long price){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public void setPrice(long pirce){
        this.price = price;
        updatedAt= LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public void setProductName(String productName) {
        this.productName = productName;
        updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public void setCategory(Category category) {
        this.category = category;
        updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public void setDescription(String description) {
        this.description = description;
        updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
