package com.example.testcrudSpringBootMustache.repos;

import com.example.testcrudSpringBootMustache.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByBrand(String brand);

    Product findById(long id);

    List<Product> findByName(String name);
}
