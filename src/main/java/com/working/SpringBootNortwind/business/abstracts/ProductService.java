package com.working.SpringBootNortwind.business.abstracts;

import com.working.SpringBootNortwind.core.utilities.results.DataResult;
import com.working.SpringBootNortwind.core.utilities.results.Result;
import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo,int pageSize);
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);
    //DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);
    //DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
