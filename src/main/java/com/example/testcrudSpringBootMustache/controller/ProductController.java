package com.example.testcrudSpringBootMustache.controller;

import com.example.testcrudSpringBootMustache.domain.Product;
import com.example.testcrudSpringBootMustache.repos.ProductRepo;
import com.example.testcrudSpringBootMustache.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String products(@RequestParam(required = false, defaultValue = "") String filter ,Map<String, Object> model) {
        Iterable<Product> products = productRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByName(filter);
        } else {
            products = productRepo.findAll();
        }

        model.put("products", products);
        model.put("filter", filter);

        return "products";
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam String brand,
            @RequestParam Integer price,
            @RequestParam Integer quantity,
            Map<String, Object> model) {

        Product product = new Product(name, brand, price, quantity);

        productRepo.save(product);
        Iterable<Product> products = productRepo.findAll();

        model.putIfAbsent("products", products);

        return "products";
    }

    @GetMapping("/leftovers")
    public String leftovers(Map<String, Object> model) {
        Iterable<Product> leftovers = productRepo
                .findAll()
                .stream()
                .filter((product -> product.getQuantity() < 5))
                .collect(Collectors.toList());

        model.put("leftovers", leftovers);

        return "leftovers";
    }

    @GetMapping(value = "/products/{Id}")
    public String getProductById(Model model, @PathVariable long Id) {
        Product product = null;
        try {
            product = productRepo.findById(Id);
            model.addAttribute("allowDelete", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping(value = {"/products/add"})
    public String showAddUser(Model model) {
        Product product = new Product();
        model.addAttribute("add", true);
        model.addAttribute("product", product);

        return "product-edit";
    }

    @PostMapping(value = "/products/add")
    public String addUser(Model model,
                          @ModelAttribute("product") Product product) {
        try {
            Product newProduct = productRepo.save(product);
            return "redirect:/products/" + String.valueOf(newProduct.getId());
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);

            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "product-edit";
        }
    }
@GetMapping(value = {"/products/{Id}/edit"})
public String showEditProduct(Model model, @PathVariable long Id) {
    Product product = null;
    try {
        product = productRepo.findById(Id);
    } catch (Exception ex) {
        model.addAttribute("errorMessage", ex.getMessage());
    }
    model.addAttribute("add", false);
    model.addAttribute("product", product);
    return "product-edit";
}

    @PostMapping(value = {"/products/{Id}/edit"})
    public String updateProduct(Model model,
                             @PathVariable long Id,
                             @ModelAttribute("product") Product product) {
        try {
            Product updatedProduct = productRepo.findById(Id);
//            product.setId(Id);
            productService.update(updatedProduct);
            return "redirect:/products/" + String.valueOf(product.getId());
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);
            return "product-edit";
        }
    }

}
