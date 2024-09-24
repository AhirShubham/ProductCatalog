package com.shubham.springboot.productcatalog.Repositories;


import com.shubham.springboot.productcatalog.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Page<Product> findProductsByName(String query, Pageable pageable);

    List<Product> getByOrderByPriceDesc();

    @Query("SELECT c.name from Category c join Product p on c.id=p.category.id where p.id=:productId")
    String getCategoryNameByProductId(Long productId);

}
