package com.working.SpringBootNortwind.business.concretes;

import com.working.SpringBootNortwind.business.abstracts.ProductService;
import com.working.SpringBootNortwind.core.utilities.results.DataResult;
import com.working.SpringBootNortwind.core.utilities.results.Result;
import com.working.SpringBootNortwind.core.utilities.results.SuccessDataResult;
import com.working.SpringBootNortwind.core.utilities.results.SuccessResult;
import com.working.SpringBootNortwind.dataAccess.abstracts.ProductRepository;
import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pegeable= PageRequest.of(pageNo-1,pageSize);
        List<Product> products=this.productRepository.findAll(pegeable).getContent();
        return new SuccessDataResult<List<Product>>(products,pageNo+". sayfadaki "+pageSize+" adet ürün listelendi!");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.ASC,"productName");
        List<Product> products=this.productRepository.findAll(sort);
        return new SuccessDataResult<List<Product>>(products,"Ürünler listelendi...");
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Ürün eklendi..!");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        Product product= this.productRepository.getByProductName(productName);
        if (product ==null){
            return new SuccessDataResult<Product>(product,"Ürün Bulunamadı ..!");
        }
        return new SuccessDataResult<Product>(product,"Ürün listelendi..!");
    }

//    @Override
//    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
//        Product product= this.productRepository.getByProductNameAndCategory(productName,categoryId);
//        return new SuccessDataResult<Product>(product,"Ürün listelendi..!");
//    }
//
//    @Override
//    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
//        List<Product> products= this.productRepository.getByProductNameOrCategory(productName,categoryId);
//        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
//    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        List<Product> products= this.productRepository.getByCategoryIn(categories);
        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        List<Product> products= this.productRepository.getByProductNameContains(productName);
        if (products ==null){
            return new SuccessDataResult<List<Product>>(products,"Ürün Bulunamadı ..!");
        }
        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        List<Product> products= this.productRepository.getByProductNameStartsWith(productName);
        return new SuccessDataResult<List<Product>>(products,"Ürün listelendi..!");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        List<Product> products= this.productRepository.getByNameAndCategory(productName,categoryId);
        return new SuccessDataResult<List<Product>>(products,"Ürünler listelendi..!");
    }
}
