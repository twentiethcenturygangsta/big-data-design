package com.twentiethcenturygangsta.database.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @Column(unique = true)
    private String nickName;
    private String userName;
    private int grd;

    @Builder
    public Seller(String nickName, String userName, int grd) {
        this.nickName = nickName;
        this.userName = userName;
        this.grd = grd;
    }
}
