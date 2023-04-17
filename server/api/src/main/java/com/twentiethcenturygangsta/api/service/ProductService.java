package com.twentiethcenturygangsta.api.service;

import com.twentiethcenturygangsta.api.config.RestPage;
import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public RestPage<Product> getProducts(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return new RestPage<>(productRepository.findAll(pageable));
    }

    @Transactional
    public void sellProduct(Long id, Long quantity) {
        Product product = productRepository.findById(id).orElseThrow();
        product.decrease(quantity);
        productRepository.save(product);

    }
}
