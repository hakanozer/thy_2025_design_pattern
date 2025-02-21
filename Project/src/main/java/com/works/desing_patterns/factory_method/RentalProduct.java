package com.works.desing_patterns.factory_method;

public class RentalProduct implements IProduct{

    @Override
    public String createProduct() {
        return "RentalProduct create";
    }

}
