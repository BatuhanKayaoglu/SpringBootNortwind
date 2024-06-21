package com.working.SpringBootNortwind.business.concretes;

import com.working.SpringBootNortwind.business.abstracts.ProductService;
import com.working.SpringBootNortwind.core.utilities.results.DataResult;
import com.working.SpringBootNortwind.core.utilities.results.Result;
import com.working.SpringBootNortwind.core.utilities.results.SuccessDataResult;
import com.working.SpringBootNortwind.core.utilities.results.SuccessResult;
import com.working.SpringBootNortwind.dataAccess.abstracts.ProductRepository;
import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 public class ProductManager implements ProductService {

    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public DataResult<List<Product>> getAll() {
        List<Product> products= this.productRepository.findAll();
        return new SuccessDataResult<List<Product>>(products,"Data Listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Ürün eklendi..!");
    }
}
