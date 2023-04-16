package com.twentiethcenturygangsta.database;

import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.domain.Seller;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductDto {

    private SellerDto seller;
    private List<ProductImageDto> productImages;
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
    private Long quantity;

    public ProductDto(){}

    @Builder
    public ProductDto(Product product) {
        this.seller = SellerDto.builder().seller(product.getSeller()).build();
        this.productImages = product.getProductImages().stream().map(ProductImageDto::new).collect(Collectors.toList());
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
        this.salePrice = product.getSalePrice();
        this.rating = product.getRating();
        this.detailPageUrl = product.getDetailPageUrl();
        this.delivery = product.getDelivery();
        this.reviewCount = product.getReviewCount();
        this.buySatisfy = product.getBuySatisfy();
        this.isMinor = product.getIsMinor();
        this.quantity = product.getQuantity();
    }
}
