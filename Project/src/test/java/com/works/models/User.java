package com.works.models;

import java.time.OffsetDateTime;

@lombok.Data
public class User {
    private long id;
    private String name;
    private String email;
    private String role;
    private Object rememberToken;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
