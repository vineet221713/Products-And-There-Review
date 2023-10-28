package com.vineet.Assignment3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"cDate", "uDate"}, allowGetters = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @CreatedDate
    private LocalDateTime cDate;
    @LastModifiedDate
    private LocalDateTime uDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // Constructors, getters, and setters


    public Product() {
    }

    public Product(Long id, String name, double price, LocalDateTime cDate, LocalDateTime uDate, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cDate = cDate;
        this.uDate = uDate;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}