package com.twentiethcenturygangsta.database.dto;

import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.domain.ProductCSV;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductDto {
    private String name;
    private int price;
    private int salePrice;
    private String rating;
    private String detailPageUrl;
    private String delivery;
    private int reviewCount;
    private int buySatisfy;
    private String isMinor;
    private int discount;
    private int mileage;

    @Builder
    public ProductDto(ProductCSV productCSV) {
        this.name = productCSV.getProductName();
        this.price = productCSV.getProductPrice();
        this.salePrice = productCSV.getSalePrice();
        this.rating = productCSV.getRating();
        this.detailPageUrl = productCSV.getDetailPageUrl();
        this.delivery = productCSV.getDelivery();
        this.reviewCount = productCSV.getReviewCount();
        this.buySatisfy = productCSV.getBuySatisfy();
        this.isMinor = productCSV.getMinorYn();
    }

    public Product toEntity(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .salePrice(productDto.getSalePrice())
                .rating(productDto.getRating())
                .detailPageUrl(productDto.getDetailPageUrl())
                .delivery(productDto.getDelivery())
                .reviewCount(productDto.getReviewCount())
                .buySatisfy(productDto.getBuySatisfy())
                .isMinor(productDto.getIsMinor())
                .build();
    }
}
