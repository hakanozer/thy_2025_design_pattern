package com.works.desing_patterns.factory_method;

public class SaleProduct implements IProduct{

    @Override
    public String createProduct() {
        return "SaleProduct create";
    }

}
