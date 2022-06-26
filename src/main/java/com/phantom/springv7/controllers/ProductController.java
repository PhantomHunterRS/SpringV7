package com.phantom.springv7.controllers;

import com.phantom.springv7.exceptions.MarketError;
import com.phantom.springv7.model.Product;
import com.phantom.springv7.services.ProductService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Data
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }
//    @GetMapping("/product/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id){
//        Optional<Product> product = productService.findById(id);
//        if (product.isEmpty()){
//           return new ResponseEntity<>(new MarketError("Product id = "+ id + "not found"),HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }

// V2 exception
    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id){


        return productService.findById(id).get();
    }

    @PostMapping("/newProduct")
    public Product create(@RequestBody Product product){
        Product productIn = new Product();
        productIn.setId(product.getId());
        productIn.setTitle(product.getTitle());
        productIn.setCost(product.getCost());
        return productService.save(productIn);
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

}
