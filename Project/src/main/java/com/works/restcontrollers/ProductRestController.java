package com.works.restcontrollers;

import com.works.desing_patterns.builder.ProductDirectory;
import com.works.entities.Product;
import com.works.services.ProductService;
import com.works.utils.EFabricType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService productService;
    final ProductDirectory productDirectory;

    @GetMapping("create/{type}")
    public String create(@PathVariable EFabricType type) {
        return productService.createProduct(type).createProduct();
    }

    @PostMapping("save/{type}")
    public Product save(@PathVariable int type, @RequestBody Product product) {
        return productDirectory.save(type, product);
    }

    @GetMapping("list/{type}")
    public List<Product> list(@PathVariable int type) {
        return productDirectory.findAll(type);
    }

}
