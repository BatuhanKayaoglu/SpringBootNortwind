package com.working.SpringBootNortwind.business.concretes;

import com.working.SpringBootNortwind.business.abstracts.ProductService;
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
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
