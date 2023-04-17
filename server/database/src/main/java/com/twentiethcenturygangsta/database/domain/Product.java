package com.twentiethcenturygangsta.database.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product implements Serializable {

    private static final int STOCK_MINIMUM = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImages = new ArrayList<>();
    @Column(unique = true)
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

    @ColumnDefault("100")
    private Long quantity;

    @Builder
    public Product(Long id, Seller seller, String code, String name, int price, int salePrice, String rating, String detailPageUrl, String delivery, int reviewCount, int buySatisfy, String isMinor) {
        this.id = id;
        this.seller = seller;
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
        this.quantity = 100L;
    }

    public void decrease(Long quantity) {
        if (hasQuantity(quantity)) {
            this.quantity = this.quantity - quantity;
        } else {
            throw new RuntimeException("does not decrease product's quantity");
        }
    }

    public boolean hasQuantity(Long quantity) {
        return this.quantity - quantity >= 0;
    }
}