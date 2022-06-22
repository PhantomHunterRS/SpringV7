package com.phantom.springv7.repositories;

import com.phantom.springv7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("INSERT into Product p (p.title, p.cost) values (p.title = :title, p.cost = :cost)")
    Product create(String title, int cost);
    List<Product> findByCostBetween(int minCost,int maxCost);
    //Product existsProductByTitleAndCost(String title,int cost);

}
