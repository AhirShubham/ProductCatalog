package com.shubham.springboot.productcatalog.controllers;

import com.shubham.springboot.productcatalog.dtos.CategoryDto;
import com.shubham.springboot.productcatalog.dtos.ProductDto;
import com.shubham.springboot.productcatalog.dtos.SearchRequestDto;
import com.shubham.springboot.productcatalog.models.Product;
import com.shubham.springboot.productcatalog.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {
        //Page is returned because it returns metadata of paging as well in response
        Page<Product> products = searchService.searchProducts(searchRequestDto.getQuery(),searchRequestDto.getPageNumber(),searchRequestDto.getPageLimit(),searchRequestDto.getSortParamList());

        return products;
    }

    private ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setDescription(product.getDescription());
        if (product.getCategory() != null) {
            CategoryDto category = new CategoryDto();
            category.setId(product.getCategory().getId());
            category.setName(product.getCategory().getName());
            productDto.setCategory(category);
        }
        return productDto;
    }
}