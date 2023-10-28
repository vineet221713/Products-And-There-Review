package com.vineet.Assignment3.Service;

import com.vineet.Assignment3.Entity.Product;
import com.vineet.Assignment3.Entity.Review;
import com.vineet.Assignment3.Exception.ProductNotFoundException;
import com.vineet.Assignment3.Repositories.ProductRepository;
import com.vineet.Assignment3.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
private ProductRepository productRepository;
    @Autowired
private ReviewRepository reviewRepository;
    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException
    {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return products;
    }

    @Override
    public Product getProductById(Long productId) {
        try {
            return productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException("No product found"));
        } catch (ProductNotFoundException ex) {
            // Handle the exception or rethrow as an unchecked exception
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        if (productRepository.existsById(productId)) {
            product.setId(productId);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Review> getReviewsForProduct(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            return product.getReviews();
        }
        return null;
    }
}
