package com.taes.r2dbc.service;

import com.taes.r2dbc.entity.ProductMap;
import com.taes.r2dbc.repository.ProductMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductMapService {

    private final ProductMapRepository productMapRepository;

    @Autowired
    public ProductMapService(ProductMapRepository productMapRepository) {
        this.productMapRepository = productMapRepository;
    }

    public Flux<ProductMap> getAll()
    {
        return productMapRepository.getAllProductMap();
    }
}
