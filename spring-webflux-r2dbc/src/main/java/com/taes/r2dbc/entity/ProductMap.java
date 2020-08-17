package com.taes.r2dbc.entity;

import lombok.Data;

@Data
public class ProductMap {
    private int productId;
    private String productName;
    private String productDetail;
    private int userId;
    private String userName;
    private int locationId;
    private String locationName;
}
