package com.works.services;

import com.works.desing_patterns.bridge.CompleteShip;
import com.works.desing_patterns.bridge.IShip;
import com.works.desing_patterns.bridge.ProductA;
import com.works.desing_patterns.factory_method.*;
import com.works.entities.Customer;
import com.works.impls.IBasket;

import com.works.utils.EFabricType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService implements com.works.impls.IProduct, IBasket {

    final CreateFabric createFabric;
    final IShip productA;
    final IShip productB;

    public IProduct createProduct(EFabricType efabricType) {
        IProduct iProduct = switch (efabricType) {
            case sale -> new FabricSaleProduct().createProduct();
            case rental -> new FabricRentalProduct().createProduct();
        };
        CompleteShip completeShip = new CompleteShip(productB);
        completeShip.operation(iProduct.hashCode());
        return iProduct;
    }

    @Override
    public void getOneProduct(int pid) {
        Map<Integer, Object> map = new LinkedHashMap<>();
        map.put(1, null);
        map.put(2, "ali");
        map.put(3, true);
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
