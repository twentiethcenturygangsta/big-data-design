package com.twentiethcenturygangsta.api.service;

import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final RedissonClient redissonClient;

    public Page<Product> getProducts(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findAll(pageable);
    }

    @Transactional
    public void sellProduct(Long id, Long quantity) {

        RLock lock = redissonClient.getLock(id.toString());
        try {
            boolean hasGetLock = lock.tryLock(5, 1, TimeUnit.SECONDS);

            if (!hasGetLock) {
                log.info("Lock 획득 실패");
            }
            Product product = productRepository.findById(id).orElseThrow();
            product.decrease(quantity);
            productRepository.save(product);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }
}
