package com.taes.r2dbc.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String registDate;
}
