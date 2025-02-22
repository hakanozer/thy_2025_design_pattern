package com.works.desing_patterns.builder;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectronicProduct implements IProductBuilder {

    final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> productList() {
        return productRepository.findAll();
    }

}
