package com.shubham.springboot.productcatalog.Controllers;

import com.shubham.springboot.productcatalog.Models.Category;
import com.shubham.springboot.productcatalog.Models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {


    @GetMapping("/products/all")
    public List<Product> getProducts() {
        Product product=new Product();
        product.setId(1);
        product.setName("Iphone");
        product.setDescription("Iphone 12");
        product.setCategory(new Category("Electronics","All electronic items",new ArrayList<>()));
        product.setPrice(80000);
        return List.of(product);
    }


    @GetMapping("/products")
    public Product getProductById(@RequestParam(value="id") Integer id) {
        Product product=new Product();
        product.setId(id);
        product.setName("Iphone");
        product.setDescription("Iphone 12");
        product.setCategory(new Category("Electronics","All electronic items",new ArrayList<>()));
        product.setPrice(80000);
        return product;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return product;
    }

}
