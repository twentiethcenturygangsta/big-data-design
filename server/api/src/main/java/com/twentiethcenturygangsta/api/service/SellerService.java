package com.twentiethcenturygangsta.api.service;

import com.twentiethcenturygangsta.database.domain.Product;
import com.twentiethcenturygangsta.database.domain.Seller;
import com.twentiethcenturygangsta.database.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    public Page<Seller> getSellers(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return sellerRepository.findAll(pageable);
    }
}
