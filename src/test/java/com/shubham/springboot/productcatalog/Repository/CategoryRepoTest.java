package com.shubham.springboot.productcatalog.Repository;

import com.shubham.springboot.productcatalog.Repositories.CategoryRepo;
import com.shubham.springboot.productcatalog.models.Category;
import com.shubham.springboot.productcatalog.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryRepoTest {


    @Autowired
    CategoryRepo categoryRepo;
    @Test
    @Transactional
    public void getByCategoryId(){

        List<Category> c = categoryRepo.findAll();

        for(Category category:c){
            System.out.println(category.getName());
            for(Product p:category.getProducts()){
                System.out.println(p.getName());
            }
        }


    }
}
