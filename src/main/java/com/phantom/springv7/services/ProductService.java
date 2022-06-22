package com.phantom.springv7.services;

import com.phantom.springv7.model.Product;
import com.phantom.springv7.repositories.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
    public Product create(String title,int cost){
        return productRepository.create(title,cost);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
    public List<Product> findByCostBetween(int minCost,int maxCost){
     return productRepository.findByCostBetween(minCost,maxCost);
    }
}
