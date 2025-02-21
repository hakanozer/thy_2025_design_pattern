package com.works.restcontrollers;

import com.works.desing_patterns.factory_method.IProduct;
import com.works.services.ProductService;
import com.works.utils.EFabricType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService productService;

    @GetMapping("create/{type}")
    public String create(@PathVariable EFabricType type) {
        return productService.createProduct(type).createProduct();
    }

}
