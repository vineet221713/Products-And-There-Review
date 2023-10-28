package com.vineet.Assignment3.Service;

import com.vineet.Assignment3.Entity.Product;
import com.vineet.Assignment3.Entity.Review;
import com.vineet.Assignment3.Repositories.ProductRepository;
import com.vineet.Assignment3.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Review addReviewToProduct(Long productId, Review review) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            review.setProduct(product);
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
