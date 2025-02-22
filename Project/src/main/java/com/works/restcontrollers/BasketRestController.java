package com.works.restcontrollers;

import com.works.desing_patterns.adapter.BasketAdapter;
import com.works.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("basket")
@RequiredArgsConstructor
public class BasketRestController {

    final BasketAdapter basketAdapter;

    @GetMapping("add/{pid}")
    public Product add(@PathVariable long pid) {
        return basketAdapter.addBasket(pid);
    }

    @GetMapping("list")
    public List<Product> list() {
        return basketAdapter.listBasket();
    }

}
