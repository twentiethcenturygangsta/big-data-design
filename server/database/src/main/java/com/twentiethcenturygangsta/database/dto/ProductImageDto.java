package com.twentiethcenturygangsta.database.dto;

import com.twentiethcenturygangsta.database.domain.ProductCSV;
import com.twentiethcenturygangsta.database.domain.ProductImage;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductImageDto {
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

    @Builder
    public ProductImageDto(ProductCSV productCSV) {
        this.base = productCSV.getProductImage();
        this.size100 = productCSV.getProductImage100();
        this.size110 = productCSV.getProductImage110();
        this.size120 = productCSV.getProductImage120();
        this.size130 = productCSV.getProductImage130();
        this.size140 = productCSV.getProductImage140();
        this.size150 = productCSV.getProductImage150();
        this.size170 = productCSV.getProductImage170();
        this.size200 = productCSV.getProductImage200();
        this.size250 = productCSV.getProductImage250();
        this.size270 = productCSV.getProductImage270();
        this.size300 = productCSV.getProductImage300();
    }

    public ProductImage toEntity(ProductImageDto productImageDto) {
        return ProductImage.builder()
                .base(this.getBase())
                .size100(productImageDto.getSize100())
                .size110(productImageDto.getSize110())
                .size120(productImageDto.getSize120())
                .size130(productImageDto.getSize130())
                .size140(productImageDto.getSize140())
                .size150(productImageDto.getSize150())
                .size170(productImageDto.getSize170())
                .size200(productImageDto.getSize200())
                .size250(productImageDto.getSize250())
                .size270(productImageDto.getSize270())
                .size300(productImageDto.getSize300())
                .build();
    }
}
