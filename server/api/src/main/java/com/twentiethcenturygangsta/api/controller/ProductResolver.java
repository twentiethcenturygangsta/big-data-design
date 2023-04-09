package com.twentiethcenturygangsta.api.controller;

import com.twentiethcenturygangsta.api.service.ProductService;
import com.twentiethcenturygangsta.database.domain.Product;

import lombok.RequiredArgsConstructor;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductResolver {
    private final ProductService productService;

    @SchemaMapping(typeName = "Query", value = "getProducts")
    public List<Product> getProducts(@Argument int pageNum, @Argument int pageSize) {
        return productService.getProducts(pageNum, pageSize).stream().collect(Collectors.toList());
    }
}
