package com.phantom.springv7.repositories;

import com.phantom.springv7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
