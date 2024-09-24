package com.shubham.springboot.productcatalog.services;

import com.shubham.springboot.productcatalog.dtos.SortParam;
import com.shubham.springboot.productcatalog.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService{

    Page<Product> searchProducts(String query, Integer pageNumber, Integer pageLimit, List<SortParam> sortParamList);


 }
