package com.working.SpringBootNortwind.business.abstracts;

import com.working.SpringBootNortwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
