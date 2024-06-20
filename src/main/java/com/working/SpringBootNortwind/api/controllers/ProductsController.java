package com.working.SpringBootNortwind.api.controllers;

import com.working.SpringBootNortwind.business.abstracts.ProductService;
import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/alldata")
    public List<Product> getAll(){
    return this.productService.getAll();
    }
}
