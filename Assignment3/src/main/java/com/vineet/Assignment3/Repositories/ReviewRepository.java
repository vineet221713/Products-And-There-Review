package com.vineet.Assignment3.Repositories;


import com.vineet.Assignment3.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}