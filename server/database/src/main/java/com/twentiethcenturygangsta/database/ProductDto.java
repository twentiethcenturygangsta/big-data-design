package com.twentiethcenturygangsta.database;

import com.twentiethcenturygangsta.database.domain.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Transactional
public class ProductDto {

    private final Long id;
    private final SellerDto seller;
    private final List<ProductImageDto> productImages;
    private final String code;
    private final String name;
    private final int price;
    private final int salePrice;
    private final String rating;
    private final String detailPageUrl;
    private final String delivery;
    private final int reviewCount;
    private final int buySatisfy;
    private final String isMinor;
    private final Long quantity;

    public ProductDto(){}

    @Builder
    public ProductDto(Product product) {
        this.id = product.getId();
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
