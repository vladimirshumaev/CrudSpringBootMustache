package com.example.testcrudSpringBootMustache.service;

import com.example.testcrudSpringBootMustache.domain.Product;
import com.example.testcrudSpringBootMustache.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public void update(Product product) throws Exception {
        if (StringUtils.isEmpty(product.getName())) {
            throw new Exception("Name is required");
        }
        if (StringUtils.isEmpty(product.getBrand())) {
            throw new Exception("Brand is required");
        }
        if (!productRepo.existsById(product.getId())) {
            throw new Exception("Cannot find Product with id: " + product.getId());
        }
        productRepo.save(product);
    }
}
