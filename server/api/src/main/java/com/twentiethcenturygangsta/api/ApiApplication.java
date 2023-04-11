package com.twentiethcenturygangsta.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.twentiethcenturygangsta.cache-redis")
@EntityScan(basePackages = "com.twentiethcenturygangsta.database")
@EnableJpaRepositories(basePackages = "com.twentiethcenturygangsta.database")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
