package com.phantom.springv7.controllers;

import com.phantom.springv7.model.Product;
import com.phantom.springv7.services.ProductService;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Data
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id).get();
    }
    @GetMapping("/newProducts")
    public Product saveOrCreate(@PathVariable Long id){
        return productService.findById(id).get();
    }


}
