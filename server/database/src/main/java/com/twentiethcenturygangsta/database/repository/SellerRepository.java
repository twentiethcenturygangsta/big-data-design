package com.twentiethcenturygangsta.database.repository;


import com.twentiethcenturygangsta.database.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
