package com.working.SpringBootNortwind.business.abstracts;

import com.working.SpringBootNortwind.core.utilities.results.DataResult;
import com.working.SpringBootNortwind.core.utilities.results.Result;
import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    DataResult<List<Product>> getAll();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByProductNameAndCategory(String productName, int categoryId);
}
