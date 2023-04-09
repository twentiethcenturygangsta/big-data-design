package com.twentiethcenturygangsta.database.repository;

import com.twentiethcenturygangsta.database.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@GraphQlRepository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);
    Page<Product> findAll(Pageable pageable);
}
