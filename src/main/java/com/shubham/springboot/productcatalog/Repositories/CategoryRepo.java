package com.shubham.springboot.productcatalog.Repositories;

import com.shubham.springboot.productcatalog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
