package com.working.SpringBootNortwind.dataAccess.abstracts;

import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);
    //Product getByProductNameAndCategory(String productName,int categoryId);
    //List<Product> getByProductNameOrCategory(String productName, int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
   List<Product> getByNameAndCategory(String productName, int categoryId);
}
