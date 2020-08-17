package com.taes.r2dbc.controller;

import com.taes.r2dbc.entity.ProductMap;
import com.taes.r2dbc.service.ProductMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ProductMapController {
    private final ProductMapService productMapService;

    @Autowired
    public ProductMapController(ProductMapService productMapService) {
        this.productMapService = productMapService;
    }

    @GetMapping("/product-map")
    public Flux<ProductMap> getAll()
    {
        return productMapService.getAll();
    }
}
