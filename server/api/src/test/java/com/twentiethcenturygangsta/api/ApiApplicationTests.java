package com.twentiethcenturygangsta.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
//@EntityScan(basePackages = "com.twentiethcenturygangsta.database")
//@EnableJpaRepositories(basePackages = "com.twentiethcenturygangsta.database")
class ApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
