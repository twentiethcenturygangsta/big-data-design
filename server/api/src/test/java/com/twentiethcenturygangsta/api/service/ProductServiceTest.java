package com.twentiethcenturygangsta.api.service;

import com.twentiethcenturygangsta.api.config.RedissonLockProductClient;
import com.twentiethcenturygangsta.api.init.InitInstance;
import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.domain.Seller;
import com.twentiethcenturygangsta.database.repository.ProductRepository;
import com.twentiethcenturygangsta.database.repository.SellerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private RedissonLockProductClient productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @BeforeEach
    public void before() {
        Seller seller = InitInstance.createAdminSeller();
        sellerRepository.save(seller);
        Product product = InitInstance.createAdminProduct(seller);
        productRepository.save(product);
    }

    @AfterEach
    public void after() {
        sellerRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void 동시에_100개_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);

        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try{
                    productService.decrease(1L, 1L);
//                    productService.sellProduct(1L, 1L);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        Product foundProduct = productRepository.findById(1L).orElseThrow();
        assertEquals(0L, foundProduct.getQuantity());
    }
}