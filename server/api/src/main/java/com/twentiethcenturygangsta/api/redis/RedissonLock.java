package com.twentiethcenturygangsta.api.redis;

import com.twentiethcenturygangsta.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedissonLock {
    private final RedissonClient redissonClient;
    private final ProductService productService;

    public void decrease(Long key, Long quantity) {
        RLock lock = redissonClient.getLock(key.toString());
        try {
            boolean hasGetLock = lock.tryLock(5, 1, TimeUnit.SECONDS);

            if (!hasGetLock) {
                log.info("Lock 획득 실패");
            }

            productService.sellProduct(key, quantity);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
