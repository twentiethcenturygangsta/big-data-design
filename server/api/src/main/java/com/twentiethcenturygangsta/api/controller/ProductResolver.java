package com.twentiethcenturygangsta.api.controller;

import com.twentiethcenturygangsta.api.service.ProductService;
import com.twentiethcenturygangsta.database.ProductDto;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductResolver {
    private final ProductService productService;

    @Cacheable(value="Product", key = "#pageNum + #pageSize", unless = "#result == null", cacheManager = "cacheManager")
    @SchemaMapping(typeName = "Query", value = "getProducts")
    public List<ProductDto> getProducts(@Argument int pageNum, @Argument int pageSize) {
        return productService.getProducts(pageNum, pageSize).stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
