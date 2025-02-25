package com.works.models;

@lombok.Data
public class Data {
    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private User user;
}
