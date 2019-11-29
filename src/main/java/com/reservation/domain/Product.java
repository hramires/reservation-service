package com.reservation.domain;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double price;
    @ManyToOne()
    @JoinColumn(columnDefinition = "user_id", referencedColumnName = "id")
    private User user;

    public Product() {

    }

    public Product(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public Product(String description, Double price, User user) {
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
