package com.twentiethcenturygangsta.database.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ProductCSV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ProductCode;
    private String ProductName;
    private int ProductPrice;
    private int SalePrice;
    private String Rating;
    private String DetailPageUrl;
    private String Delivery;
    private int ReviewCount;
    private int BuySatisfy;
    private String MinorYn;
    private String Benefit;
    private String ProductImage;
    private String ProductImage100;
    private String ProductImage110;
    private String ProductImage120;
    private String ProductImage130;
    private String ProductImage140;
    private String ProductImage150;
    private String ProductImage170;
    private String ProductImage200;
    private String ProductImage250;
    private String ProductImage270;
    private String ProductImage300;
    private String Text1;
    private String Text2;
    private String SellerNick;
    private String Seller;
    private int SellerGrd;

    public ProductCSV(String ProductName, String ProductCode, int ProductPrice, int salePrice, String rating, String detailPageUrl, String delivery, int reviewCount, int buySatisfy, String minorYn, String benefit, String productImage, String productImage100, String productImage110, String productImage120, String productImage130, String productImage140, String productImage150, String productImage170, String productImage200, String productImage250, String productImage270, String productImage300, String Text1, String Text2, String sellerNick, String seller, int sellerGrd) {
        this.ProductName = ProductName;
        this.ProductCode = ProductCode;
        this.ProductPrice = ProductPrice;
        this.SalePrice = salePrice;
        this.Rating = rating;
        this.DetailPageUrl = detailPageUrl;
        this.Delivery = delivery;
        this.ReviewCount = reviewCount;
        this.BuySatisfy = buySatisfy;
        this.MinorYn = minorYn;
        this.Benefit = benefit;
        this.ProductImage = productImage;
        this.ProductImage100 = productImage100;
        this.ProductImage110 = productImage110;
        this.ProductImage120 = productImage120;
        this.ProductImage130 = productImage130;
        this.ProductImage140 = productImage140;
        this.ProductImage150 = productImage150;
        this.ProductImage170 = productImage170;
        this.ProductImage200 = productImage200;
        this.ProductImage250 = productImage250;
        this.ProductImage270 = productImage270;
        this.ProductImage300 = productImage300;
        this.Text1 = Text1;
        this.Text2 = Text2;
        this.SellerNick = sellerNick;
        this.Seller = seller;
        this.SellerGrd = sellerGrd;
    }
}
