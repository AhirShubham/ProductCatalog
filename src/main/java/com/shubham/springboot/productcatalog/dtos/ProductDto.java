package com.shubham.springboot.productcatalog.dtos;

import com.shubham.springboot.productcatalog.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;

    private String description;

    private Double price;

    private String imageUrl;

    private CategoryDto category;
}
