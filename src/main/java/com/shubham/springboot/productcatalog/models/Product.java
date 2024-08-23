package com.shubham.springboot.productcatalog.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Category category;
}
