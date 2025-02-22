package com.works.desing_patterns.bridge;

import org.springframework.stereotype.Component;

@Component
public class ProductB implements IShip{

    @Override
    public void sendShip(long pid) {
        System.out.println("ProductB Ship Send");
    }

}
