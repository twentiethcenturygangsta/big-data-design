package com.twentiethcenturygangsta.api.config;

import com.twentiethcenturygangsta.api.service.ProductService;
import com.twentiethcenturygangsta.database.ProductDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedissonLockProductClient {
    private final RedissonClient redissonClient;
    private final ProductService productService;

    public ProductDto decrease(Long id, Long quantity) {
        RLock lock = redissonClient.getLock(id.toString());
        try {
            boolean hasGetLock = lock.tryLock(60, 3, TimeUnit.SECONDS);

            if (!hasGetLock) {
                log.info("Lock 획득 실패");
            }
            return productService.purchaseProduct(id, quantity);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
