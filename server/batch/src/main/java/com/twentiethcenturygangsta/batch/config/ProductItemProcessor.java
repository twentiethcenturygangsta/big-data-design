package com.twentiethcenturygangsta.batch.config;

import com.twentiethcenturygangsta.database.domain.*;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;


@Configuration
@RequiredArgsConstructor
public class ProductItemProcessor implements ItemProcessor<ProductCSV, ProductCSV> {
    private static final Logger log = LoggerFactory.getLogger(ProductItemProcessor.class);

    @Override
    @Transactional
    public ProductCSV process(final ProductCSV item) throws Exception {
        try {
            log.info("step = {} {}", item.getId(), item.getProductName());
        } catch (Exception e) {
            log.info("exception = {}", e.getMessage());
        }
        return item;
    }
}
