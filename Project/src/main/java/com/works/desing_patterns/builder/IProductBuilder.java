package com.works.desing_patterns.builder;

import com.works.entities.Product;

import java.util.List;

public interface IProductBuilder {

    Product createProduct(Product product);
    List<Product> productList();
    List<Product> searchProduct(String q);
}
