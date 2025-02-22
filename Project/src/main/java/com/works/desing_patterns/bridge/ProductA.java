package com.works.desing_patterns.bridge;

import org.springframework.stereotype.Component;

@Component
public class ProductA implements IShip {

    @Override
    public void sendShip(long pid) {
        System.out.println("ProductA Ship Send");
    }

}
