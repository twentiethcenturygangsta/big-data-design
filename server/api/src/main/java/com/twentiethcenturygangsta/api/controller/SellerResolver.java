package com.twentiethcenturygangsta.api.controller;

import com.twentiethcenturygangsta.api.service.SellerService;
import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.domain.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class SellerResolver {
    private final SellerService sellerService;

    //    Cacheable
    @SchemaMapping(typeName = "Query", value = "getSellers")
    public List<Seller> getSellers(@Argument int pageNum, @Argument int pageSize) {
        return sellerService.getSellers(pageNum, pageSize).stream().collect(Collectors.toList());
    }

    @SchemaMapping(typeName = "Query", value = "getSeller")
    public Seller getSeller(@Argument Long id) {
        return sellerService.getSeller(id);
    }
}
