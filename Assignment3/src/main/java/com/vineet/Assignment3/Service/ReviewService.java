package com.vineet.Assignment3.Service;

import com.vineet.Assignment3.Entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    Review addReviewToProduct(Long productId, Review review);
    void deleteReview(Long reviewId);

    // Add other review-related methods as needed
}
