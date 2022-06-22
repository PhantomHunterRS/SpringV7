package com.phantom.springv7.controllers;

import com.phantom.springv7.model.Product;
import com.phantom.springv7.services.ProductService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id).get();
    }
    @PostMapping("/newProduct")
    public Product create(@RequestBody String title, @RequestBody int cost){
        return productService.create(title,cost);
    }
    @GetMapping("/product/delete/{id}")
    public List<Product> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return productService.findAll();
    }
    @PostMapping("/costBetween")
    public List<Product> findByCostBetween(@RequestBody() int minCost , @RequestBody int maxCost){
        return productService.findByCostBetween(minCost,maxCost);
    }
//    @GetMapping("/costBetween")
//    public List<Product> findByCostBetween(@RequestParam(name = "min") int minCost,
//                                           @RequestParam(name = "max") int maxCost){
//        return productService.findByCostBetween(minCost,maxCost);
//    }

}
