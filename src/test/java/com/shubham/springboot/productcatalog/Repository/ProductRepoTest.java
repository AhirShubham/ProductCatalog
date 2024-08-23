package com.shubham.springboot.productcatalog.Repository;

import com.shubham.springboot.productcatalog.Repositories.ProductRepo;
import com.shubham.springboot.productcatalog.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;

    @Test
    @Transactional
    public void testGetByOrderByPriceAsc() {
        List<Product> products = productRepo.getByOrderByPriceDesc();
        products.stream().forEach(product -> System.out.println(product.getPrice()));
    }

    @Test
    @Transactional
    public void testGetCategoryNameByProductId() {
        String categoryName = productRepo.getCategoryNameByProductId(1L);
        System.out.println(categoryName);
    }

    @Test
    @Transactional
    public void getProductById(){

        Product p = productRepo.findById(1L).get();
        System.out.println(p.getName());
    }

}
