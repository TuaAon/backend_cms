package com.main.backend_cms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Product {
    @Id
    private String id;
    private String name;
    
    private Double price;
    private Long amount;
    private String description;
    private String[] category;
    private String picture;


    public Product() {
    }

    public Product(String name,
                   Double price,
                   Long amount,
                   String description,
                   String[] category,
                   String picture) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.picture = picture;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getCategory() {
        return this.category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
