package com.works.desing_patterns.adapter;

import com.works.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketAdapter implements IBasket{

    private final Basket basket;

    @Override
    public Product addBasket(long pid) {
        return basket.addBasket(pid);
    }

    public List<Product> listBasket() {
        return basket.basketList();
    }


}
