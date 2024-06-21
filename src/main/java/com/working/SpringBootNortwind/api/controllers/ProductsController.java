package com.working.SpringBootNortwind.api.controllers;

import com.working.SpringBootNortwind.business.abstracts.ProductService;
import com.working.SpringBootNortwind.core.utilities.results.DataResult;
import com.working.SpringBootNortwind.core.utilities.results.Result;
import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll()
    {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product)
    {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName)
    {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName)
    {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameAndCategory")
    public DataResult<List<Product>> getByProductNameAndCategory(@RequestParam String productName, int categoryId)
    {
        return this.productService.getByNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo,@RequestParam  int pageSize)
    {
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted()
    {
        return this.productService.getAllSorted();
    }

}
