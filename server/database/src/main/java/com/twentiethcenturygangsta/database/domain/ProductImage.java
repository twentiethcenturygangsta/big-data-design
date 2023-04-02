package com.twentiethcenturygangsta.database.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String base;
    private String size100;
    private String size110;
    private String size120;
    private String size130;
    private String size140;
    private String size150;
    private String size170;
    private String size200;
    private String size250;
    private String size270;
    private String size300;
}
