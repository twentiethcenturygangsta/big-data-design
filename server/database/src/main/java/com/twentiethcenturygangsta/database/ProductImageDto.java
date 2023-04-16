package com.twentiethcenturygangsta.database;

import com.twentiethcenturygangsta.database.domain.ProductImage;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductImageDto {

//    private ProductDto product;
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

    public ProductImageDto() {}

    @Builder
    public ProductImageDto(ProductImage productImage) {
//        this.product = ProductDto.builder().product(productImage.getProduct()).build();
        this.base = productImage.getBase();
        this.size100 = productImage.getSize100();
        this.size110 = productImage.getSize110();
        this.size120 = productImage.getSize120();
        this.size130 = productImage.getSize130();
        this.size140 = productImage.getSize140();
        this.size150 = productImage.getSize150();
        this.size170 = productImage.getSize170();
        this.size200 = productImage.getSize200();
        this.size250 = productImage.getSize250();
        this.size270 = productImage.getSize270();
        this.size300 = productImage.getSize300();
    }
}
