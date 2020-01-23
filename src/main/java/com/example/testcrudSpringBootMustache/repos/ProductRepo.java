package com.example.testcrudSpringBootMustache.repos;

import com.example.testcrudSpringBootMustache.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByName(String name);

    Product findByBrand(String brand);

    Product findById(long id);
}
