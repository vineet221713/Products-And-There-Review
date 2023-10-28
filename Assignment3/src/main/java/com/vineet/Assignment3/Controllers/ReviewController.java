package com.vineet.Assignment3.Controllers;

import com.vineet.Assignment3.Entity.Review;
import com.vineet.Assignment3.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/products/{productId}/reviews")
    public ResponseEntity<Review> addReviewToProduct(@PathVariable Long productId, @RequestBody Review review) {
        Review addedReview = reviewService.addReviewToProduct(productId, review);

        if (addedReview != null) {
            return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Or another appropriate status
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long productId, @PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
