package com.works.services;

import com.works.impls.IBasket;

import java.util.Random;

public class BasketService implements IBasket {

    String name = "Ali";
    Random random = new Random();

    public BasketService() {
        System.out.println( random.nextInt() );
    }

    @Override
    public void getOneProduct(int pid) {

    }

}
