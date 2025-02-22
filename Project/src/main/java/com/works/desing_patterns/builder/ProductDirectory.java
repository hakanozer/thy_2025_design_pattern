package com.works.desing_patterns.builder;

import com.works.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDirectory {

    final ModaProduct modaProduct;
    final ElectronicProduct electronicProduct;

    public Product save(int type, Product product) {
        if (type == 1) {
            return modaProduct.createProduct(product);
        }else if (type == 2) {
            return electronicProduct.createProduct(product);
        }
        return null;
    }

    public List<Product> findAll(int type) {
        if (type == 1) {
            return modaProduct.productList();
        }else if (type == 2) {
            return electronicProduct.productList();
        }
        return null;
    }

}
