package com.works.desing_patterns.factory_method;

public class FabricRentalProduct implements IProductFactory{

    @Override
    public IProduct createProduct() {
        return new RentalProduct();
    }

}
