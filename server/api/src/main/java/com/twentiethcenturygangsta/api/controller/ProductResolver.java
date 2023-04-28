package com.twentiethcenturygangsta.api.controller;

import com.twentiethcenturygangsta.api.config.RedissonLockProductClient;
import com.twentiethcenturygangsta.api.service.ProductService;
import com.twentiethcenturygangsta.database.ProductDto;

import com.twentiethcenturygangsta.database.domain.Product;
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
    private final RedissonLockProductClient redissonLockProductClient;

    @Cacheable(value="Product", key = "'Product::' + 'page'+ #pageNum + 'size' + #pageSize", unless = "#result == null", cacheManager = "cacheManager")
    @SchemaMapping(typeName = "Query", value = "getProducts")
    public List<ProductDto> getProducts(@Argument int pageNum, @Argument int pageSize) {
        return productService.getProducts(pageNum, pageSize).stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @SchemaMapping(typeName = "Mutation", value = "purchaseProduct")
    public ProductDto purchaseProduct(@Argument Long id, @Argument Long quantity) {
        return redissonLockProductClient.decrease(id, quantity);
    }
}
