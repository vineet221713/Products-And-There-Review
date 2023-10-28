package com.vineet.Assignment3.Service;

import com.vineet.Assignment3.Entity.Product;
import com.vineet.Assignment3.Entity.Review;
import com.vineet.Assignment3.Exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws ProductNotFoundException;
    Product getProductById(Long productId);
    Product createProduct(Product product);
    Product updateProduct(Long productId, Product product);
    void deleteProduct(Long productId);

    // Virtual population of reviews for a product
    List<Review> getReviewsForProduct(Long productId);
}
