package com.shubham.springboot.productcatalog.services;

import com.shubham.springboot.productcatalog.models.Product;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public Product createProduct(Product product);

    Product replaceProduct(Long id, Product product);
}
