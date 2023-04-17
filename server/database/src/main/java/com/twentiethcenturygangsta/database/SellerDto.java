package com.twentiethcenturygangsta.database;

import com.twentiethcenturygangsta.database.domain.Seller;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SellerDto {

    private String nickName;
    private String userName;
    private int grd;

    public SellerDto(){}

    @Builder
    public SellerDto(Seller seller) {
        this.nickName = seller.getNickName();
        this.userName = seller.getUserName();
        this.grd = seller.getGrd();
    }
}
