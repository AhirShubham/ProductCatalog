package com.shubham.springboot.productcatalog.services;

import com.shubham.springboot.productcatalog.Repositories.ProductRepo;
import com.shubham.springboot.productcatalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productCatalog")
@Primary
public class ProductCatalogService implements IProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> response = productRepo.findById(id);
        return response.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    };

    @Override
    public Product createProduct(Product product) {
          return productRepo.save(product);

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
