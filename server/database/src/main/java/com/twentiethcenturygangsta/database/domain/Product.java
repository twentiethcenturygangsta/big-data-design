package com.twentiethcenturygangsta.database.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int salePrice;
    private String rating;
    private String detailPageUrl;
    private String delivery;
    private int reviewCount;
    private int buySatisfy;
    private boolean isMinor;
    private int discount;
    private int mileage;
}