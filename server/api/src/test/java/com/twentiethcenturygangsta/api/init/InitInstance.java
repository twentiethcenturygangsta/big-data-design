package com.twentiethcenturygangsta.api.init;

import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.domain.Seller;

public class InitInstance {

    private static final String PRODUCT_SELLER = "testAdmin";
    private static final String PRODUCT_CODE = "123456789";
    private static final String PRODUCT_NAME = "admin";
    private static final int PRODUCT_PRICE = 1000;
    private static final int PRODUCT_SALE_PRICE = 990;
    private static final String PRODUCT_RATING = "4.9";
    private static final String PRODUCT_DETAIL_PAGE_URL = "https://testUser.test.com/admin";
    private static final String PRODUCT_DELIVERY = "Y";
    private static final int PRODUCT_REVIEW_COUNT = 17;
    private static final int PRODUCT_BUY_SATISFY = 1;
    private static final String PRODUCT_IS_MINOR = "Y";
    private static final Long PRODUCT_QUANTITY = 100L;

    private static final String SELLER_NICKNAME = "adminGood";
    private static final String SELLER_USERNAME = "adminJohn";
    private static final int SELLER_GRD = 0;

    private InitInstance(){}

    public static Product createAdminProduct(Seller seller) {
        return Product.builder()
                .seller(seller)
                .code(PRODUCT_CODE)
                .name(PRODUCT_NAME)
                .price(PRODUCT_PRICE)
                .salePrice(PRODUCT_SALE_PRICE)
                .rating(PRODUCT_RATING)
                .detailPageUrl(PRODUCT_DETAIL_PAGE_URL)
                .delivery(PRODUCT_DELIVERY)
                .reviewCount(PRODUCT_REVIEW_COUNT)
                .buySatisfy(PRODUCT_BUY_SATISFY)
                .isMinor(PRODUCT_IS_MINOR)
                .build();
    }

    public static Seller createAdminSeller() {
        return Seller.builder()
                .nickName(SELLER_NICKNAME)
                .userName(SELLER_USERNAME)
                .grd(SELLER_GRD)
                .build();
    }
}
