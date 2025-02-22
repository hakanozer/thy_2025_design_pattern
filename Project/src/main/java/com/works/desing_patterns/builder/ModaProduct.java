package com.works.desing_patterns.builder;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModaProduct implements IProductBuilder {

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

    @Override
    public List<Product> searchProduct(String q) {
        return productRepository.findByTitleContainsOrDescriptionContainsAllIgnoreCase(q,q);
    }

}
