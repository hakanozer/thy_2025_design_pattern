package com.works.services;

import com.works.entities.Customer;
import com.works.impls.IBasket;
import com.works.impls.IProduct;

public class ProductService implements IProduct, IBasket {
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
