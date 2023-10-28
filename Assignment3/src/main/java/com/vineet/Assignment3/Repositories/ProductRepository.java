package com.vineet.Assignment3.Repositories;

import com.vineet.Assignment3.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}