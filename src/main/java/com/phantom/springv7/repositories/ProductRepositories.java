package com.phantom.springv7.repositories;

import com.phantom.springv7.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product,Long> {
}
