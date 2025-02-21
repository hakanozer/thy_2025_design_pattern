package com.works.services;

import com.works.desing_patterns.factory_method.*;
import com.works.entities.Customer;
import com.works.impls.IBasket;

import com.works.utils.EFabricType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService implements com.works.impls.IProduct, IBasket {

    final CreateFabric createFabric;

    public IProduct createProduct(EFabricType efabricType) {
        return switch (efabricType) {
            case sale -> new FabricSaleProduct().createProduct();
            case rental -> new FabricRentalProduct().createProduct();
        };
    }

    @Override
    public void getOneProduct(int pid) {

    }

    @Override
    public void saveProduct() {

    }

    @Override
    public void deleteProduct() {

    }

    public Customer createCustomer() {
        return new Customer();
    }
}
