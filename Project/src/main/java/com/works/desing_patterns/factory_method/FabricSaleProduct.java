package com.works.desing_patterns.factory_method;

public class FabricSaleProduct implements  IProductFactory{

    @Override
    public IProduct createProduct() {
        return new SaleProduct();
    }



}
