package com.vineet.Assignment3.Exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long reviewId) {
        super("Review not found with id: " + reviewId);
    }
}
