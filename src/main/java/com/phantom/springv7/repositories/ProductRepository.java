package com.phantom.springv7.repositories;

import com.phantom.springv7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCostBetween(int minCost,int maxCost);
    Product existsProductByTitleAndCost(String title,int cost);

}
