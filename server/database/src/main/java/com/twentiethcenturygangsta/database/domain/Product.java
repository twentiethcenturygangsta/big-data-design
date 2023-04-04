package com.twentiethcenturygangsta.database.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private int price;
    private int salePrice;
    private String rating;
    private String detailPageUrl;
    private String delivery;
    private int reviewCount;
    private int buySatisfy;
    private String isMinor;
//    private int discount;
//    private int mileage;

    @Builder
    public Product(Long id, String code, String name, int price, int salePrice, String rating, String detailPageUrl, String delivery, int reviewCount, int buySatisfy, String isMinor) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.rating = rating;
        this.detailPageUrl = detailPageUrl;
        this.delivery = delivery;
        this.reviewCount = reviewCount;
        this.buySatisfy = buySatisfy;
        this.isMinor = isMinor;
//        this.discount = discount;
//        this.mileage = mileage;
    }
}