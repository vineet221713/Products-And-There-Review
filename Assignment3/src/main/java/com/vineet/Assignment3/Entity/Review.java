package com.vineet.Assignment3.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String description;

    @CreatedDate
    private LocalDateTime cDate;
    @LastModifiedDate
    private LocalDateTime uDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


// Constructors, getters, and setters


    public Review() {
    }

    public Review(Long id, String userId, String description, LocalDateTime cDate, LocalDateTime uDate, Product product) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.cDate = cDate;
        this.uDate = uDate;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getcDate() {
        return cDate;
    }

    public void setcDate(LocalDateTime cDate) {
        this.cDate = cDate;
    }

    public LocalDateTime getuDate() {
        return uDate;
    }

    public void setuDate(LocalDateTime uDate) {
        this.uDate = uDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}