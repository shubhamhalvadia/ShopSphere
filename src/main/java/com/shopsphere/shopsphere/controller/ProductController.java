package com.shopsphere.shopsphere.controller;

import com.shopsphere.shopsphere.model.Product;
import com.shopsphere.shopsphere.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepo.save(product);
    }
}