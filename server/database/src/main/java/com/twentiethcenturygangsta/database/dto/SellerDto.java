package com.twentiethcenturygangsta.database.dto;

import com.twentiethcenturygangsta.database.domain.ProductCSV;
import com.twentiethcenturygangsta.database.domain.Seller;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerDto {
    private String nickName;
    private String userName;
    private int grd;

    @Builder
    public SellerDto(ProductCSV productCSV) {
        this.nickName = productCSV.getSellerNick();
        this.userName = productCSV.getSeller();
        this.grd = productCSV.getSellerGrd();
    }

    public Seller toEntity(SellerDto sellerDto) {
        return Seller.builder()
                .nickName(sellerDto.getNickName())
                .userName(sellerDto.getUserName())
                .grd(sellerDto.getGrd())
                .build();
    }
}
