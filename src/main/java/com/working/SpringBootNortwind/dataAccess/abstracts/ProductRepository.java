package com.working.SpringBootNortwind.dataAccess.abstracts;

import com.working.SpringBootNortwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
