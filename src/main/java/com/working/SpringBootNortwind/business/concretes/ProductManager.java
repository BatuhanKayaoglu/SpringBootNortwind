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

    @Override
    public DataResult<Product> getByProductName(String productName) {
        Product product= this.productRepository.getByProductName(productName);
        return new SuccessDataResult<Product>(product,"Ürün listelendi..!");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        Product product= this.productRepository.getByProductNameAndCategoryId(productName,categoryId);
        return new SuccessDataResult<Product>(product,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        List<Product> products= this.productRepository.getByProductNameOrCategoryId(productName,categoryId);
        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        List<Product> products= this.productRepository.getByCategoryIdIn(categories);
        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        List<Product> products= this.productRepository.getByProductNameContains(productName);
        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        List<Product> products= this.productRepository.getByProductNameStartsWith(productName);
        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameAndCategory(String productName, int categoryId) {
        List<Product> products= this.productRepository.getByProductNameAndCategory(productName,categoryId);
        return new SuccessDataResult<List<Product>>(products,"Ürünler listelendi..!");
    }
}
