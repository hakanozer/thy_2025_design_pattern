package com.works.entities;

import com.works.customvalids.TC;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String name;
    private String surname;

    @TC
    private String tc;

    @Email
    @NotEmpty
    @NotNull
    private String email;

    @Size(min = 3, max = 6)
    @NotEmpty
    @NotNull
    private String password;

    private Integer age;

}
