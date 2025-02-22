package com.works.desing_patterns.adapter;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Basket{

    final ProductRepository productRepository;
    final HttpServletRequest httpServletRequest;

    public List<Product> basketList() {
        return productRepository.findAll();
    }

    public Product addBasket(long pid) {
        Object obj = httpServletRequest.getSession().getAttribute("customer");
        return productRepository.findById(pid).orElse(null);
    }

}
